package com.bayviewglen.zork;

/*
 * Class Room - a room in an adventure game.
 *
 * Author:  Michael Kolling
 * Version: 1.1
 * Date:    August 2000
 * 
 * This class is part of Zork. Zork is a simple, text based adventure game.
 *
 * "Room" represents one location in the scenery of the game.  It is 
 * connected to at most four other rooms via exits.  The exits are labelled
 * north, east, south, west.  For each direction, the room stores a reference
 * to the Neighboring room, or null if there is no exit in that direction.
 */
import java.util.Set;

import com.bayviewglen.zork.Items.Item;

import java.util.HashMap;
import java.util.Iterator;

class Room {
	private String roomName;
	private String description;
	private HashMap<String, Room> exits; // stores exits of this room.
	private Inventory roomInventory;

	/**
	 * Create a room described "description". Initially, it has no exits.
	 * "description" is something like "a kitchen" or "an open court yard".
	 */
	public Room(String description) {
		this.description = description;
		exits = new HashMap<String, Room>();
		roomInventory = new Inventory();
	}

	public Room() {
		// default constructor.
		roomName = "DEFAULT ROOM";
		description = "DEFAULT DESCRIPTION";
		exits = new HashMap<String, Room>();
		roomInventory = new Inventory();
	}

	public Inventory getRoomInventory() {
		return roomInventory;
	}

	public void removeFromInventory(Item item) {
		roomInventory.removeFromInventory(item);
	}

	public void addToInventory(Item item) {
		roomInventory.addToInventory(item);
	}

	public void setExit(char direction, Room r) throws Exception {
		String dir = "";
		switch (direction) {
		case 'E':
			dir = "east";
			break;
		case 'W':
			dir = "west";
			break;
		case 'S':
			dir = "south";
			break;
		case 'N':
			dir = "north";
			break;
		case 'U':
			dir = "up";
			break;
		case 'D':
			dir = "down";
			break;
		default:
			throw new Exception("Invalid Direction");

		}

		exits.put(dir, r);
	}

	/**
	 * Define the exits of this room. Every direction either leads to another room
	 * or is null (no exit there).
	 */
	public void setExits(Room north, Room east, Room south, Room west, Room up, Room down) {
		if (north != null)
			exits.put("north", north);
		if (east != null)
			exits.put("east", east);
		if (south != null)
			exits.put("south", south);
		if (west != null)
			exits.put("west", west);
		if (up != null)
			exits.put("up", up);
		if (up != null)
			exits.put("down", down);

	}

	/**
	 * Return the description of the room (the one that was defined in the
	 * constructor).
	 */
	public String shortDescription() {
		return "Room: " + roomName;
	}

	/**
	 * Return a long description of this room, on the form: You are in the kitchen.
	 * Exits: north west
	 */
	public String longDescription() {
		if (roomInventory.numberOfItems() <= 0) {
			return description;
		} else {
			return description + "\n\nIn the room you see the following:\n" + roomInventory.toStringLong();
		}
	}

	/**
	 * Return a string describing the room's exits, for example "Exits: north west
	 * ".
	 */
	public String exitString() {
		String returnString = "Exits:";
		Set<String> keys = exits.keySet();
		for (Iterator<String> iter = keys.iterator(); iter.hasNext();)
			returnString += " " + iter.next();
		return returnString;
	}

	/**
	 * Return the room that is reached if we go from this room in direction
	 * "direction". If there is no room in that direction, return null.
	 */
	public Room nextRoom(String direction) {
		if (direction != null && exits.get(direction) != null) {
			return (Room) exits.get(direction);
		} else {
			return null;
		}
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isStairs(Room currentRoom, Room nextRoom) {
		if (currentRoom.getRoomName().contains("F") && nextRoom.getRoomName().contains("F")) {
			return true;
		}
		return false;
	}
}
