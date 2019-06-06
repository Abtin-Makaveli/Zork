package com.bayviewglen.zork;

import java.util.ArrayList;

public class Monster {
	private Room currentRoom;
	private ArrayList<String> possibleDirections;
	private String direction;
	public Monster(Room startingRoom) {
		possibleDirections = new ArrayList<String>();
		currentRoom = startingRoom;
		startingRoom.getRoomName();
		possibleDirections.add("north");
		possibleDirections.add("south");
		possibleDirections.add("east");
		possibleDirections.add("west");
		possibleDirections.add("up");
		possibleDirections.add("down");
	}

	// changes rooms randomly
	public void changeRooms() {
		direction = roll();
		while (currentRoom.nextRoom(direction) == null) {
			direction = roll();
		}
		currentRoom = currentRoom.nextRoom(direction);
	}

	public boolean isNearPlayer(Room playerRoom) {
		if ((currentRoom.nextRoom("north") != null && currentRoom.nextRoom("north").getRoomName().equals(playerRoom.getRoomName()))
				|| (currentRoom.nextRoom("south") != null && currentRoom.nextRoom("south").getRoomName().equals(playerRoom.getRoomName()))
				|| (currentRoom.nextRoom("east") != null && currentRoom.nextRoom("east").getRoomName().equals(playerRoom.getRoomName()))
				|| (currentRoom.nextRoom("west") != null && currentRoom.nextRoom("west").getRoomName().equals(playerRoom.getRoomName()))
				|| (currentRoom.nextRoom("up") != null && currentRoom.nextRoom("up").getRoomName().equals(playerRoom.getRoomName()))
				|| (currentRoom.nextRoom("down") != null && currentRoom.nextRoom("down").getRoomName().equals(playerRoom.getRoomName()))) {
			return true;
		}
		return false;
	}
	
	public String roll() {
		int random = (int) (Math.random() * possibleDirections.size());
		for (int i = 0; i < possibleDirections.size(); i++) {
			if (random == i) {
				direction = possibleDirections.get(i);
			}
		}
		return direction;
	}

}
