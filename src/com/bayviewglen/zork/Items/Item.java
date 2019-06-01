package com.bayviewglen.zork.Items;

public class Item {
	private String name;
	private int weight;
	private String description;
	private boolean usable;
	
	public Item(String name, int weight, String description) {
		super();
		this.name = name;
		this.weight = weight;
		usable = true;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isUsable() {
		return usable;
	}
	public void changeUsable() {
		if (usable) {
			usable = false;
		} else {
			usable = true;
		}
	}
}
