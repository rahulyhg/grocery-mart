package com.app.grocery.stub;

import java.util.ArrayList;
import java.util.HashMap;

import com.app.grocery.beans.Inventory;
import com.app.grocery.beans.Promotions;
import com.app.grocery.beans.Transactions;

public class StubManager {
	
	static StubManager stubManager = null;
	ArrayList<Inventory> productStub = new ArrayList<Inventory>();
	ArrayList<Transactions> transactionStub = new ArrayList<Transactions>();
	Promotions promotionObject = new Promotions();
	
	private StubManager (){};
	
	public static StubManager getInstance(){
		if (null == stubManager) {
			stubManager = new StubManager();
			initProducts(stubManager);
			initDiscounts(stubManager);
		}
		return stubManager;
	}

	private static void initDiscounts(StubManager stubObject) {
		stubObject.getPromotionMap().put("Beverages", 5.0);
	}

	public ArrayList<Inventory> getInventoryList() {
		return productStub;
	}

	public ArrayList<Transactions> getTransactionList() {
		return transactionStub;
	}
	
	public HashMap<String, Double> getPromotionMap() {
		return promotionObject.getCategoryPromotions();
	}

	private static void initProducts(StubManager stubObject) {
		stubObject.getInventoryList().add(new Inventory(stubObject.getInventoryList().size(), "Carrot", "Fruits/Vegetables", 32.0, 26.0, true, 1000, false, true));
		stubObject.getInventoryList().add(new Inventory(stubObject.getInventoryList().size(), "Apple", "Fruits/Vegetables", 32.0, 26.0, true, 1000, false, true));
		stubObject.getInventoryList().add(new Inventory(stubObject.getInventoryList().size(), "Coke", "Beverages", 35.0, 24.0, true, 1000, false, false));
	}
	
}
