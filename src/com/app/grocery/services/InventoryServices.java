package com.app.grocery.services;

import java.util.HashMap;
import java.util.Map;

import com.app.grocery.beans.Inventory;
import com.app.grocery.interfaces.InventoryInterface;
import com.app.grocery.services.shared.ItemIndexMapper;
import com.app.grocery.stub.StubManager;

public class InventoryServices implements InventoryInterface {
	
	public final static InventoryServices inventoryServices = new InventoryServices();

	protected InventoryServices() {
	};

	public static InventoryServices getInventoryServices() {
		return inventoryServices;
	}

	@Override
	public void addItem(Inventory product) {
	}

	@Override
	public void setPrice(int itemID, Double newPrice) {
	}

	@Override
	public void removeItem(Inventory product) {
	}

	@Override
	public boolean isItemAvailable() {
		return false;
	}

	@Override
	public void listAvailableItems() {
		System.out.println(StubManager.getInstance().getInventoryList());
	}

	public Double getPrice(String itemName){
		Integer index = ItemIndexMapper.getInstance().getItemIndexMapper().get(itemName);
		Inventory item = StubManager.getInstance().getInventoryList().get(index);
		return item.getRetailPrice();
	}
	
	public Double getDiscountForItem(String itemName){
		Double returnValue = 0.0;
		Integer index = ItemIndexMapper.getInstance().getItemIndexMapper().get(itemName);
		Inventory item = StubManager.getInstance().getInventoryList().get(index);
		if(null != item)
			if (null != StubManager.getInstance().getPromotionMap().get(item.getCategory()))
				returnValue = StubManager.getInstance().getPromotionMap().get(item.getCategory());
		return returnValue;
	}

	public void updatesAvailableItemsInInventory(
			HashMap<String, Integer> shoppingBasket) {

		for(Map.Entry<String, Integer> rowData: shoppingBasket.entrySet()){
			Integer index = ItemIndexMapper.getInstance().getItemIndexMapper().get(rowData.getKey());
			Inventory item = StubManager.getInstance().getInventoryList().get(index);
			int availableQuantity = item.getQuantity();
			if (availableQuantity > rowData.getValue()){
				availableQuantity = availableQuantity - rowData.getValue();
				item.setQuantity(availableQuantity);
			}
			
		}
		
	}
}
