package com.bayviewglen.zork.Items;

public class Flashlight extends Item {
	private boolean isOn = false;
	private int numBatteries = 0;

	public Flashlight(String name, int weight, String description) {
		super(name, weight, description);
	}

	public void giveBatteries() {
		numBatteries += 2;
		super.setDescription("A flashlight with " + numBatteries + " charges left");
	}
	
	public boolean hasBatteries() {
		if (numBatteries > 0) {
			return true;
		}
		return false;
	}

	public void turnOn() {
		if (numBatteries < 0) {
			isOn = true;
			numBatteries--;
			super.setDescription("A flashlight with " + numBatteries + " charges left");
		}
	}

	public boolean getIsOn() {
		return isOn;
	}

}
