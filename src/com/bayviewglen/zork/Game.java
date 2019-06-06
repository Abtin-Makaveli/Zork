package com.bayviewglen.zork;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import com.bayviewglen.zork.Items.Batteries;
import com.bayviewglen.zork.Items.Bike;
import com.bayviewglen.zork.Items.Bleach;
import com.bayviewglen.zork.Items.Flashlight;
import com.bayviewglen.zork.Items.GameKey;
import com.bayviewglen.zork.Items.Item;
import com.bayviewglen.zork.Items.Rune;
import com.bayviewglen.zork.Items.Wine;

/**
 * Class Game - the main class of the "Zork" game.
 *
 * Author: Michael Kolling Version: 1.1 Date: March 2000
 * 
 * This class is the main class of the "Zork" application. Zork is a very
 * simple, text based adventure game. Users can walk around some scenery. That's
 * all. It should really be extended to make it more interesting!
 * 
 * To play this game, create an instance of this class and call the "play"
 * routine.
 * 
 * This main class creates and initializes all the others: it creates all rooms,
 * creates the parser and starts the game. It also evaluates the commands that
 * the parser returns.
 */
class Game {
	private Parser parser;
	private Room currentRoom;
	private Inventory playerInventory;
	private Monster monster;
	private int monsterTicker = 0;

	// items
	private Flashlight flashlight = new Flashlight("flashlight", 5, "An empty flashlight");
	private Batteries batteries = new Batteries("batteries", 2, "A twin pack of batteries");
	private Bleach bleach = new Bleach("bleach", 9,
			"A bottle with it's label scratched off, but it smells strongly of bleach");
	private Bike bike = new Bike("bicycle", 50, "A broken bike, it doesn't look fixable");
	private Wine wine = new Wine("wine", 5, "A bottle of wine");
	private Rune rune = new Rune("rune", 1, "an old pebble with the tesla logo on it");

	// This is a MASTER object that contains all of the rooms and is easily
	// accessible.
	// The key will be the name of the room -> no spaces (Use all caps and
	// underscore -> Great Room would have a key of GREAT_ROOM
	// In a hashmap, keys are case sensitive.
	// masterRoomMap.get("GREAT_ROOM") will return the Room Object that is the Great
	// Room (assuming you have one).
	private HashMap<String, Room> masterRoomMap; // room map
	private ArrayList<Item> itemList = new ArrayList<Item>();

	private void initRooms(String fileName) throws Exception {
		masterRoomMap = new HashMap<String, Room>();
		Scanner roomScanner;
		try {
			HashMap<String, HashMap<String, String>> exits = new HashMap<String, HashMap<String, String>>();
			roomScanner = new Scanner(new File(fileName));
			while (roomScanner.hasNext()) {
				Room room = new Room();
				// Read the Name
				String roomName = roomScanner.nextLine();
				room.setRoomName(roomName.split(":")[1].trim());
				// Read the Description
				String roomDescription = roomScanner.nextLine();
				room.setDescription(roomDescription.split(":")[1].replaceAll("<br>", "\n").trim());
				// Read the Exits
				String roomExits = roomScanner.nextLine();
				// An array of strings in the format E-RoomName
				String[] rooms = roomExits.split(":")[1].split(",");
				HashMap<String, String> temp = new HashMap<String, String>();
				for (String s : rooms) {
					temp.put(s.split("-")[0].trim(), s.split("-")[1]);
				}

				exits.put(roomName.substring(10).trim().toUpperCase().replaceAll(" ", "_"), temp);

				// This puts the room we created (Without the exits in the masterMap)
				masterRoomMap.put(roomName.toUpperCase().substring(10).trim().replaceAll(" ", "_"), room);

				// Now we better set the exits.
			}

			for (String key : masterRoomMap.keySet()) {
				Room roomTemp = masterRoomMap.get(key);
				HashMap<String, String> tempExits = exits.get(key);
				for (String s : tempExits.keySet()) {
					// s = direction
					// value is the room.

					String roomName2 = tempExits.get(s.trim());
					Room exitRoom = masterRoomMap.get(roomName2.toUpperCase().replaceAll(" ", "_"));
					roomTemp.setExit(s.trim().charAt(0), exitRoom);

				}

			}

			roomScanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void initMonster() {
		monster = new Monster(masterRoomMap.get("F0HALLWAY"));
	}

	/**
	 * put all the items in itemList
	 */
	private void initItems() {
		itemList.add(flashlight);
		masterRoomMap.get("UPSTAIRS_OFFICE").addToInventory(flashlight);
		itemList.add(batteries);
		masterRoomMap.get("PARENT'S_ROOM").addToInventory(batteries);
		masterRoomMap.get("ELECTRIC_ROOM").addToInventory(batteries); // second location you can find batteries
		itemList.add(bleach);
		masterRoomMap.get("LAUNDRY_ROOM").addToInventory(bleach);
		masterRoomMap.get("KITCHEN").addToInventory(bleach); // second location you can find bleach
		itemList.add(bike);
		masterRoomMap.get("SHED").addToInventory(bike);
		itemList.add(wine);
		masterRoomMap.get("WINE_CELLAR").addToInventory(wine);
		itemList.add(rune);
		masterRoomMap.get("LIVING_ROOM").addToInventory(rune);
	}

	/**
	 * Create the game and initialize its internal map.
	 */
	public Game() {
		try {
			initRooms("data/Rooms.dat");
			currentRoom = masterRoomMap.get("YOUR_ROOM");
			playerInventory = new Inventory(30);
			initItems();
			initMonster();
		} catch (Exception e) {
			e.printStackTrace();
		}
		parser = new Parser();
	}

	/**
	 * Main play routine. Loops until end of play.
	 */
	public void play() {
		printWelcome();
// Enter the main command loop.  Here we repeatedly read commands and
		// execute them until the game is over.

		boolean finished = false;
		while (!finished) {
			Command command = parser.getCommand();
			finished = processCommand(command);
		}
		System.out.println(
				"Hope you enjoyed playing our mini horror text-based adventure game\nThanks,\nAbtin, Ben, Shariar and Bill");
	}

	/**
	 * Print out the opening message for the player.
	 */
	private void printWelcome() {
		System.out.println();
		System.out.println("You wake up late at night in a cold sweat.");
		System.out.println("You remember hearing a scratching sound...");
		System.out.println("Type 'help' if you need help.");
		System.out.println();
		System.out.println(currentRoom.longDescription());
	}

	/**
	 * Given a command, process (that is: execute) the command. If this command ends
	 * the game, true is returned, otherwise false is returned.
	 */
	private boolean processCommand(Command command) {
		if (command.isUnknown()) {
			System.out.println("I don't know what you mean...");
			return false;
		}
		String commandWord = command.getCommandWord();
		if (commandWord.equals("help")) {
			printHelp();
		} else if (commandWord.equals("go")) {
			goRoom(command);
		} else if (commandWord.equals("n") || commandWord.equals("s") || commandWord.equals("e")
				|| commandWord.equals("w") || commandWord.equals("u") || commandWord.equals("d")) {
			goRoom(command);
		} else if (commandWord.equals("quit")) {
			if (command.hasSecondWord()) {
				System.out.println("Quit is a one word command!");
			} else {
				return true; // signal that we want to quit
			}
		} else if (commandWord.equals("eat")) {
			if (!command.hasSecondWord()) {
				System.out.println("Eat what?");
			} else {
				System.out.println("You stop yourself before taking a bite, \"now is not the time\" you think to yourself.");
			}
		} else if (commandWord.equals("look")) {
			look();
		} else if (commandWord.equals("turn") || commandWord.contentEquals("use")) {
			use(command);
		} else if (commandWord.equals("take")) {
			take(command);
		} else if (commandWord.equals("inventory") || commandWord.equals("i")) {
			inventory();
		} else if (commandWord.equals("drop")) {
			drop(command);
		} else if (commandWord.equals("summon")) {
			summon(command);
		} else if (commandWord.equals("drink")) {
			drink(command);
		} else if (commandWord.equals("suicide")) {
			System.out.println("You scratch your wrists until they start bleeding,\nas you keep losing blood your vision dims, you wonder, why did it have to be you.\nY O U  D I E D");
			return true;
		}
		return false;
	}

// implementations of user commands:
	/**
	 * Print out some help information. Here we print some stupid, cryptic message
	 * and a list of the command words.
	 */
	private void printHelp() {
		System.out.println("You are waken up by a strange sound. You are alone. You wander...");
		System.out.println("You can travel to diferent directions using North, South, East, West, Up and Down.");
		System.out.println();
		System.out.println("Your command words are:");
		parser.showCommands();
	}

	/**
	 * Try to go to one direction. If there is an exit, enter the new room,
	 * otherwise print an error message.
	 */
	private void goRoom(Command command) {
		String commandWord = command.getCommandWord();
		String direction = null;
		if (commandWord.equals("n") || commandWord.equals("s") || commandWord.equals("e") || commandWord.equals("w")
				|| commandWord.equals("u") || commandWord.equals("d")) {
			if (commandWord.equals("n")) {
				direction = "north";
			} else if (commandWord.equals("s")) {
				direction = "south";
			} else if (commandWord.equals("e")) {
				direction = "east";
			} else if (commandWord.equals("w")) {
				direction = "west";
			} else if (commandWord.equals("u")) {
				direction = "up";
			} else if (commandWord.equals("d")) {
				direction = "down";
			}
		} else {
			direction = command.getSecondWord();
		}
		// flashlight turn is over, turn off flashlight
		if (flashlight.getIsOn()) {
			flashlight.turnOff();
		}
		// Try to leave current room.
		Room nextRoom = currentRoom.nextRoom(direction);
		if (nextRoom == null) {
			System.out.println("There's nothing that way!");
		} else if (currentRoom.isStairs(currentRoom, currentRoom.nextRoom(direction))) {
			currentRoom = nextRoom;
			Animation.stairAnimation();
			System.out.println(currentRoom.longDescription());
		} else if (currentRoom.nextRoom(direction).getRoomName().equals("Attic")) {
			currentRoom = nextRoom;
			Animation.atticAnimation();
			System.out.println(currentRoom.longDescription());
		} else if (currentRoom.nextRoom(direction).getRoomName().equals("Cop Patrol")) {
			currentRoom = nextRoom;
			Animation.copAnimation();
			System.out.println(currentRoom.longDescription());
			System.out.println("Type 'quit' to leave the  game, or feel free to look around the map.");
			return;
		} else {
			currentRoom = nextRoom;
			Animation.doorAnimation();
			System.out.println(currentRoom.longDescription());
		}

		if (!command.hasSecondWord() && !command.getCommandWord().equals("n") && !command.getCommandWord().equals("s")
				&& !command.getCommandWord().equals("e") && !command.getCommandWord().equals("w")
				&& !command.getCommandWord().equals("u") && !command.getCommandWord().equals("d")) {
			// if there is no second word, we don't know where to go...
			System.out.println("Where to?");
			return;
		}
		if (command.hasThirdWord()) {
			// there is no need to say a third word
			System.out.println("You can only go to one place!");
			return;
		}

		monster.changeRooms();
		if (monster.isNearPlayer(currentRoom)) {
			monsterTicker++;
			if (monsterTicker == 3) {
				System.out.println(
						"\nThe scrathing steadily gets louder until you turn around and are face to face with the monster\nYou only see the bloodthirsty look in its eyes before it lifts its claws and cuts your head clean off.");
				System.out.println(
						"Y O U  D I E D\nT H E  E N D\nType 'quit' to leave the  game, or feel free to look around the map.");
				return;
			} else {
				System.out.println("You start to hear an ominous scratching noise");
			}
		}

	}

	private void look() {
		System.out.println("\n" + currentRoom.longDescription());
	}

	private void take(Command command) {
		if (!command.hasThirdWord()) {
			if (isItem(command.getSecondWord())) {
				Item object = null;
				for (int i = 0; i < currentRoom.getRoomInventory().numberOfItems(); i++) {
					if (currentRoom.getRoomInventory().hasItemInInventory(command.getSecondWord())) {
						object = currentRoom.getRoomInventory().getItem(command.getSecondWord());
					}
				}

				if (object.getName().equals("batteries") && playerInventory.hasItemInInventory("flashlight")
						&& object != null) {
					currentRoom.removeFromInventory(object);
					System.out.println("You put the batteries in the flashlight");
					flashlight.giveBatteries();
					return;
				} else if (object.getName().equals("flashlight") && playerInventory.hasItemInInventory("batteries")
						&& object != null) {
					playerInventory.addToInventory(object);
					currentRoom.removeFromInventory(object);
					playerInventory.removeFromInventory(playerInventory.getItem("batteries"));
					System.out.println("You took the flashlight and put the batteries in it");
					flashlight.giveBatteries();
					return;
				}

				if (playerInventory.addToInventory(object) && object != null) {
					playerInventory.addToInventory(object);
					currentRoom.removeFromInventory(object);
					System.out.println("You took the " + object.getName());
					return;
				} else {
					System.out.println("You don't have enough space in your inventory!\nTry dropping something...");
					return;
				}
			}
			System.out.println("That object doesn't exist!");
			return;
		}
		System.out.println("You can only take one item at a time!");
		return;
	}

	private void drop(Command command) {
		if (!command.hasThirdWord()) {
			if (playerInventory.hasItemInInventory(command.getSecondWord())) {
				Item object = playerInventory.getItem(command.getSecondWord());
				playerInventory.removeFromInventory(object);
				currentRoom.addToInventory(object);
				System.out.println("You dropped the " + object.getName());
				return;
			}
			System.out.println("That object doesn't exist!");
			return;
		}
		System.out.println("You can only drop one item at a time!");
		return;
	}

	private void inventory() {
		System.out.println("\nYou have:");
		System.out.println(playerInventory.toString());
	}

	private boolean isItem(String secondWord) {
		for (Item target : itemList) {
			if (secondWord.toLowerCase().equals(target.getName().toLowerCase())) {
				return true;
			}
		}
		return false;
	}

	private void use(Command command) {
		if (command.hasThirdWord() && command.getCommandWord().equals("turn") && command.getSecondWord().equals("on")
				&& command.getThirdWord().equals("flashlight")) {
			flashlight.turnOn();
			monsterTicker = 0;
			return;
		} else if (!command.hasThirdWord() && command.getCommandWord().equals("use")
				&& command.getSecondWord().equals("flashlight")) {
			flashlight.turnOn();
			monsterTicker = 0;
			return;
		} else {
			System.out.println("You can't do that!");
			return;
		}
	}

	private void summon(Command command) {
		if (playerInventory.hasItemInInventory("rune")) {
			if (command.getSecondWord().equals("elon") && command.getThirdWord().equals("musk")) {
				System.out.println("The rune starts to glow brightly...\nYou blink for a second and find yourself in what look like the inside of a spaceship.\nYou see Elon Musk in front of you, wearing a spacex t-shirt.\n'I guess I saved you' he says, 'buy the new tesla roadster'\nY O U  W I N\nT H E  E N D\nType 'quit' to leave the  game, or feel free to look around the map.");
				return;
			}
			System.out.println("That doesn't seem like what you should be summoning...");
			return;
		}
		System.out.println("Who do you think you are, a magician?");
		return;
	}
	
	private void drink(Command command) {
		
	}

}
