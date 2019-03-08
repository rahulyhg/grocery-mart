package com.app.grocery.services.shared;

import java.util.HashMap;

public class ItemIndexMapper {
	
	public static ItemIndexMapper obj = null;

	protected ItemIndexMapper() {
	};

	HashMap <String, Integer> itemIndexMapper;

	public static ItemIndexMapper getInstance() {
		if (null == obj){
			obj = new ItemIndexMapper();
			obj.setItemIndexMapper(new HashMap<String, Integer>());
		}
		return obj;
	}

	public HashMap<String, Integer> getItemIndexMapper() {
		return itemIndexMapper;
	}
	
	private void setItemIndexMapper(HashMap<String, Integer> itemIndexMapper) {
		this.itemIndexMapper = itemIndexMapper;
	}
	
}
