package com.app.grocery;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.app.grocery.core.ShoppingBasket;
import com.app.grocery.services.InventoryServices;
import com.app.grocery.services.TransactionServices;

public class GroceryApplicationTest {
	
	private static GroceryApplication groceryAppObject = null;

	@BeforeClass
	public static void setUp() throws Exception {
		groceryAppObject = new GroceryApplication();
	}

	@AfterClass
	public static void printStatement() throws Exception {
		TransactionServices.getTxnServices().printAllTransaction();
		InventoryServices.getInventoryServices().listAvailableItems();
	}

	@Test
	public void test_normalCustomerCheckout(){
		System.out.println("Normal Invoice");
		ShoppingBasket basketObject = new ShoppingBasket(); 
		basketObject.addItems("Apple", 100);
		basketObject.addItems("Carrot", 100);
		basketObject.addItems("Coke", 200);
		basketObject.setCustomerID("ABCD112233");
		groceryAppObject.checkoutBasket(basketObject);
	}
	
	@Test
	public void test_SeniorCitizenCheckout(){
		System.out.println("Invoice for Senior Citizen");
		ShoppingBasket basketObject = new ShoppingBasket(); 
		basketObject.addItems("Apple", 100);
		basketObject.addItems("Carrot", 100);
		basketObject.addItems("Coke", 200);
		basketObject.setSeniorCitizen(true);
		basketObject.setCustomerID("ABCD112244");
		groceryAppObject.checkoutBasket(basketObject);
	}
	
	@Test
	public void test_EmployeesCheckout(){
		System.out.println("Invoice for Store Employees");
		ShoppingBasket basketObject = new ShoppingBasket(); 
		basketObject.addItems("Apple", 100);
		basketObject.addItems("Carrot", 100);
		basketObject.addItems("Coke", 200);
		basketObject.setEmployeeBasket(true);
		basketObject.setCustomerID("ABCD112255");
		groceryAppObject.checkoutBasket(basketObject);
	}

}
