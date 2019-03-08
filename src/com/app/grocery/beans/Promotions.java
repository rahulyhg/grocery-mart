package com.app.grocery.beans;

import java.util.HashMap;

public class Promotions {

	HashMap<String, Double> categoryPromotions = new HashMap<String, Double>();

	public Promotions() {};
	
	public HashMap<String, Double> getCategoryPromotions() {
		return categoryPromotions;
	}

	public void setCategoryPromotions(HashMap<String, Double> categoryPromotions) {
		this.categoryPromotions = categoryPromotions;
	}
	
}

