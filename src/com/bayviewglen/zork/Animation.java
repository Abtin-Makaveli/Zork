package com.bayviewglen.zork;

public class Animation {
	private static String refresh = "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n";
	private static String lastRefresh = "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n";
	static void doorAnimation() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(refresh);

		System.out.println(" ______________");
		System.out.println("|\\ ___________ /|");
		System.out.println("| |  _ _ _ _  | |");
		System.out.println("| | | | | | | | |");
		System.out.println("| | |-+-+-+-| | |");
		System.out.println("| | |-+-+=+%| | |");
		System.out.println("| | |_|_|_|_| | |");
		System.out.println("| |    ___    | |");
		System.out.println("| |   [___] ()| |");
		System.out.println("| |         ||| |");
		System.out.println("| |         ()| |");
		System.out.println("| |           | |");
		System.out.println("| |           | |");
		System.out.println("| |           | |");
		System.out.println("|_|___________|_|");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(refresh);

		System.out.println(" ______________");
		System.out.println("|\\ ___________ /|");
		System.out.println("| |  /|,| |   | |");
		System.out.println("| | |,x,| |   | |");
		System.out.println("| | |,x,' |   | |");
		System.out.println("| | |,x   ,   | |");
		System.out.println("| | |/    |   | |");
		System.out.println("| |    /] ,   | |");
		System.out.println("| |   [/ ()   | |");
		System.out.println("| |       |   | |");
		System.out.println("| |       |   | |");
		System.out.println("| |       |   | |");
		System.out.println("| |      ,'   | |");
		System.out.println("| |   ,'      | |");
		System.out.println("|_|,'_________|_|");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(lastRefresh);
	}
	
	static void stairAnimation() {
		System.out.println(" aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa,\r\n" + 
				" 8                           8\"b,    \"Ya\r\n" + 
				" 8                           8  \"b,    \"Ya\r\n" + 
				" 8                    aaaaaaa8,   \"b,    \"Ya\r\n" + 
				" 8                    8\"b,    \"Ya   \"8\"\"\"\"\"\"8\r\n" + 
				" 8                    8  \"b,    \"Ya  8      8\r\n" + 
				" 8             aaaaaaa8,   \"b,    \"Ya8      8\r\n" + 
				" 8   A         8\"b,    \"Ya   \"8\"\"\"\"\"\"\"      8\r\n" + 
				" 8             8  \"b,    \"Ya  8             8\r\n" + 
				" 8      aaaaaa88,   \"b,    \"Ya8         B   8\r\n" + 
				" 8      8\"b,    \"Ya   \"8\"\"\"\"\"\"\"             8\r\n" + 
				" 8      8  \"b,    \"Ya  8                    8\r\n" + 
				" 8aaaaaa8,   \"b,    \"Ya8                    8\r\n" + 
				" 8\"b,    \"Ya   \"8\"\"\"\"\"\"\"                    8\r\n" + 
				" 8  \"b,    \"Ya  8                           8\r\n" + 
				" 8,   \"b,    \"Ya8                           8\r\n" + 
				"  \"Ya   \"8\"\"\"\"\"\"\"                           8\r\n" + 
				"    \"Ya  8                                  8\r\n" + 
				"      \"Ya8                                  8\r\n" + 
				"        \"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"");
	}
}
