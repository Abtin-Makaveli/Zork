package com.bayviewglen.zork;

import java.util.HashMap;

public class Inventory {

	private HashMap<String, Item> items;
	private int maxWeight;
	private int currentWeight;

	public Inventory() {
		super();
		items = new HashMap<String, Item>();
		maxWeight = Integer.MAX_VALUE;
		currentWeight = 0;
	}
	
	public Inventory(int maxWeight) {
		super();
		items = new HashMap<String, Item>();
		this.maxWeight = maxWeight;
		currentWeight = 0;
	}
	
	public boolean addToInventory(Item item) {
		if (item.getWeight() + currentWeight <= maxWeight) {
			items.put(item.getName(), item);
			currentWeight += item.getWeight();
			return true;
		}else
			return false;		
	}
	
	public Item removeFromInventory(Item item) {
		items.remove(item.getName());
		currentWeight -= item.getWeight();
		return item;
	}
	
	public boolean hasItemInInventory(String itemName) {
		return items.containsKey(itemName);
	}
	
	public int numberOfItems() {
		return items.size();
	}
	
	public String toString() {
		String temp = "";
		for (String key : items.keySet()) {
			temp += items.get(key).getName() + "\n";
		}
		
		return temp;
	}
	

}	