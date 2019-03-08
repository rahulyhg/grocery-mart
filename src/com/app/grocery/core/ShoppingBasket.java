package com.app.grocery.core;

import java.util.HashMap;

public class ShoppingBasket {
	
	boolean isEmployeeBasket;
	boolean isSeniorCitizen;
	String customerID;
	private HashMap<String, Integer> shoppingBasket;
	
	public ShoppingBasket() {
		shoppingBasket = new HashMap<String, Integer>();
	}

	public ShoppingBasket(boolean isEmployeeBasket, boolean isSeniorCitizen,
			String customerID) {
		super();
		this.isEmployeeBasket = isEmployeeBasket;
		this.isSeniorCitizen = isSeniorCitizen;
		this.customerID = customerID;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public HashMap<String, Integer> getShoppingBasket() {
		return shoppingBasket;
	}
	
	@Override
	public String toString() {
		return "ShoppingBasket [shoppingBasket=" + shoppingBasket + "]";
	}

	public void setShoppingBasket(HashMap<String, Integer> shoppingBasket) {
		this.shoppingBasket = shoppingBasket;
	}

	public void addItems(String item, int quants){
		if(shoppingBasket.containsKey(item)){
			int quantitiesInBasket = shoppingBasket.get(item);
			shoppingBasket.put(item, quantitiesInBasket+quants);
		} else {
			shoppingBasket.put(item, quants);
		}
	}
	
	public void removeItems(String item, int quants){
		if(shoppingBasket.containsKey(item)){
			int quantitiesInBasket = shoppingBasket.get(item);
			if(quantitiesInBasket > quants)
				shoppingBasket.put(item, quantitiesInBasket-quants);
		}
	}
	
	public void clearBasket(){
		shoppingBasket = new HashMap<String, Integer>();
	}

	public boolean isEmployeeBasket() {
		return isEmployeeBasket;
	}

	public void setEmployeeBasket(boolean isEmployeeBasket) {
		this.isEmployeeBasket = isEmployeeBasket;
	}

	public boolean isSeniorCitizen() {
		return isSeniorCitizen;
	}

	public void setSeniorCitizen(boolean isSeniorCitizen) {
		this.isSeniorCitizen = isSeniorCitizen;
	}
	
}
