package com.app.grocery.interfaces;

import com.app.grocery.beans.Inventory;

public interface InventoryInterface {
	
	public void addItem(Inventory product);
	public void setPrice(int itemID, Double newPrice);
	public void removeItem(Inventory product);
	public boolean isItemAvailable();
	public void listAvailableItems();
	
}
