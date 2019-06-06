package com.bayviewglen.zork.Items;

public class Flashlight extends Item{
	private boolean isOn = false;
	
	public Flashlight(String name, int weight, String description) {
		super(name, weight, description);
	}

	public void turnOn() {
		isOn = true;		
	}
	
	public boolean getIsOn() {
		return isOn;
	}

}
