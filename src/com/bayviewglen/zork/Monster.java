package com.bayviewglen.zork;

import java.util.ArrayList;

public class Monster {
	private Room currentRoom;
	private ArrayList<String> possibleDirections;
	private String direction;

	public Monster(Room startingRoom) {
		currentRoom = startingRoom;
		possibleDirections = startingRoom.arrayExits();
	}

	// changes rooms randomly
	public void changeRooms() {
		int random = (int) (Math.random() * possibleDirections.size());
		for (int i = 0; i < possibleDirections.size(); i++) {
			if (random == i) {
				direction = possibleDirections.get(i);
			}
		}
		currentRoom = currentRoom.nextRoom(direction);
	}

	public boolean isNearPlayer(Room playerRoom) {
		if (currentRoom.nextRoom("north").getRoomName().equals(playerRoom.getRoomName())
				|| currentRoom.nextRoom("south").getRoomName().equals(playerRoom.getRoomName())
				|| currentRoom.nextRoom("east").getRoomName().equals(playerRoom.getRoomName())
				|| currentRoom.nextRoom("west").getRoomName().equals(playerRoom.getRoomName())
				|| currentRoom.nextRoom("up").getRoomName().equals(playerRoom.getRoomName())
				|| currentRoom.nextRoom("down").getRoomName().equals(playerRoom.getRoomName())) {
			return true;
		}
		return false;
	}

}
