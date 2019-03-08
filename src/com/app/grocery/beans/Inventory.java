package com.app.grocery.beans;

import com.app.grocery.services.shared.ItemIndexMapper;

public class Inventory {
	int itemID;
	String itemName;
	String category;
	Double retailPrice;
	Double wholeSalePrice;
	boolean isDiscountable;
	int quantity;
	boolean isTaxable;
	boolean isWeightable;
	
	public Inventory(int itemID, String itemName, String category,
			Double retailPrice, Double wholeSalePrice, boolean isDiscountable,
			int quantity, boolean isTaxable, boolean isWeightable) {
		super();
		this.itemID = itemID;
		this.itemName = itemName;
		this.category = category;
		this.retailPrice = retailPrice;
		this.wholeSalePrice = wholeSalePrice;
		this.isDiscountable = isDiscountable;
		this.quantity = quantity;
		this.isTaxable = isTaxable;
		this.isWeightable = isWeightable;
		ItemIndexMapper.getInstance().getItemIndexMapper().put(itemName, itemID);
	}

	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Double getRetailPrice() {
		return retailPrice;
	}

	public void setRetailPrice(Double retailPrice) {
		this.retailPrice = retailPrice;
	}

	public Double getWholeSalePrice() {
		return wholeSalePrice;
	}

	public void setWholeSalePrice(Double wholeSalePrice) {
		this.wholeSalePrice = wholeSalePrice;
	}

	public boolean isDiscountable() {
		return isDiscountable;
	}

	public void setDiscountable(boolean isDiscountable) {
		this.isDiscountable = isDiscountable;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public boolean isTaxable() {
		return isTaxable;
	}

	public void setTaxable(boolean isTaxable) {
		this.isTaxable = isTaxable;
	}

	public boolean isWeightable() {
		return isWeightable;
	}

	public void setWeightable(boolean isWeightable) {
		this.isWeightable = isWeightable;
	}

	@Override
	public String toString() {
		return "Inventory [itemID=" + itemID + ", itemName=" + itemName
				+ ", category=" + category + ", retailPrice=" + retailPrice
				+ ", wholeSalePrice=" + wholeSalePrice + ", isDiscountable="
				+ isDiscountable + ", quantity=" + quantity + ", isTaxable="
				+ isTaxable + ", isWeightable=" + isWeightable + "]";
	}
	
}
