package com.app.grocery;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.app.grocery.beans.Invoices;
import com.app.grocery.core.ShoppingBasket;
import com.app.grocery.services.InventoryServices;
import com.app.grocery.services.TransactionServices;
import com.app.grocery.stub.StubManager;

public class GroceryApplication {
	StubManager connManager = StubManager.getInstance();
	
	//Method will be called, when Customer Checkout their basket. 
	//Refer GroceryApplicationTest.java for creation of BasketObject
	public void checkoutBasket(ShoppingBasket shoppingBasketObject) {
			printInvoice(shoppingBasketObject, getPriceforItems(shoppingBasketObject.getShoppingBasket()));
			updateInventory(shoppingBasketObject.getShoppingBasket());
	}

	public void updateInventory(HashMap<String, Integer> shoppingBasket) {
		InventoryServices.getInventoryServices().updatesAvailableItemsInInventory(shoppingBasket);
	}

	public void printInvoice(
			ShoppingBasket shoppingBasketObject, HashMap<Entry<String, Integer>, Double> priceforItems) {
		String attendedBy = "EMP2";
		String counterID = "C2";
		List<String> items = Arrays.asList(priceforItems.toString().replace('=', ':').split(";"));
		Double cartAmount = calculateCartValue(priceforItems);
		Double discount = getDiscountsForItems(shoppingBasketObject, priceforItems);
		Double payAmount = cartAmount - discount;
		Invoices invoiceObject = new Invoices(TransactionServices.getTxnServices().getInvoiceID(),
				shoppingBasketObject.getCustomerID(), new Date(), items , cartAmount, discount, payAmount, attendedBy, counterID);
		TransactionServices.getTxnServices().saveInvoices(invoiceObject);
		System.out.println(invoiceObject);
	}

	public Double getDiscountsForItems(
			ShoppingBasket shoppingBasketObject, HashMap<Entry<String, Integer>, Double> priceforItems) {
		Double discountedValue = 0.00;
		Double totalCartValue = 0.00;
		for(Entry<Entry<String, Integer>, Double> rowData: priceforItems.entrySet()){
			discountedValue = discountedValue + ((getDiscountPercentageForItem(rowData.getKey().getKey()) / 100) * rowData.getValue());
			totalCartValue = totalCartValue + rowData.getValue();
		}
		if(shoppingBasketObject.isEmployeeBasket())
			discountedValue = discountedValue + (totalCartValue * 0.05);
		else if(shoppingBasketObject.isSeniorCitizen())
			discountedValue = discountedValue + (totalCartValue * 0.02);
		return discountedValue;
	}

	public Double getDiscountPercentageForItem(String item) {
		return InventoryServices.getInventoryServices().getDiscountForItem(item);
	}

	public Double calculateCartValue(
			HashMap<Entry<String, Integer>, Double> priceforItems) {
		Double cartValue = 0.0;
		for(Entry<String, Integer> rowData: priceforItems.keySet()){
			Double itemPrice = priceforItems.get(rowData);
			cartValue = cartValue + itemPrice;
		}
		return cartValue;
	}

	public HashMap<Map.Entry<String, Integer>, Double> getPriceforItems(HashMap<String, Integer> shoppingBasket) {
		HashMap<Map.Entry<String, Integer>, Double> invoiceDetails = new HashMap<Map.Entry<String,Integer>, Double>();
		InventoryServices inventoryService = InventoryServices.getInventoryServices();
		for (Map.Entry<String, Integer> entrySet : shoppingBasket.entrySet()) {
			Double priceOfItem = inventoryService.getPrice(entrySet.getKey());
			priceOfItem = priceOfItem * entrySet.getValue();
			invoiceDetails.put(entrySet, priceOfItem);
		}
		return invoiceDetails;
	}
}
