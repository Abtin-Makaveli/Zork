package com.bayviewglen.zork;

public class Animation {
	private static String refresh = "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n";
	private static String lastRefresh = "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n";
	public static void doorAnimation() {
		try {
			Thread.sleep(750);
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
			Thread.sleep(750);
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
			Thread.sleep(750);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(lastRefresh);
	}
	
	public static void stairAnimation() {
		try {
			Thread.sleep(750);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(refresh);
		
		System.out.println("[]\r\n" + 
				"                    []\r\n" + 
				"                    []\r\n" + 
				"                    []\r\n" + 
				"                    []\r\n" + 
				"                    []\r\n" + 
				"   _______________  []         _________________\r\n" + 
				"   _______________) []        (_______________\r\n" + 
				"    !     !     !   []        '  !     !     !\r\n" + 
				"    !     !     !   []       ,!  !     !     !\r\n" + 
				"    !     !     !   []      ! !  !     !     !\r\n" + 
				"    !_____!_____!___[]_____'!_!__!_____!_____!_____\r\n" + 
				"                    []__,_!_!_!\r\n" + 
				"                    []_!__!_!|\r\n" + 
				"                   ,[]_!__!_!\r\n" + 
				"                 ,! []_!__!|\r\n" + 
				"               ,! ! []_!__!\r\n" + 
				"              ! ! ! []_!|\r\n" + 
				"             !! ! !|[]_|\r\n" + 
				"             !!!._|_[]\r\n" + 
				"             !!!|!_.[]\r\n" + 
				"             !|!_!__[]!.\r\n" + 
				"             !_!_!__[]! !.\r\n" + 
				"             !_!_!__[]! ! `.\r\n" + 
				"              |!_!__|]! ! ! `.\r\n" + 
				"               |_!__|]! ! ! ! `.\r\n" + 
				"                 |____|_! ! ! !  `\r\n" + 
				"                   |____|_! ! ! !\r\n" + 
				"                    []____|_! ! !\r\n" + 
				"                    []______|_! !\r\n" + 
				"                    []________|_!\r\n" + 
				"  __________________[]__________|____________________");
		try {
			Thread.sleep(750);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(refresh);
		
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa,\r\n" + 
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
		
		try {
			Thread.sleep(750);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(refresh);
		
		System.out.println("[]\r\n" + 
				"                    []\r\n" + 
				"                    []\r\n" + 
				"                    []\r\n" + 
				"                    []\r\n" + 
				"                    []\r\n" + 
				"   _______________  []         _________________\r\n" + 
				"   _______________) []        (_______________\r\n" + 
				"    !     !     !   []        '  !     !     !\r\n" + 
				"    !     !     !   []       ,!  !     !     !\r\n" + 
				"    !     !     !   []      ! !  !     !     !\r\n" + 
				"    !_____!_____!___[]_____'!_!__!_____!_____!_____\r\n" + 
				"                    []__,_!_!_!\r\n" + 
				"                    []_!__!_!|\r\n" + 
				"                   ,[]_!__!_!\r\n" + 
				"                 ,! []_!__!|\r\n" + 
				"               ,! ! []_!__!\r\n" + 
				"              ! ! ! []_!|\r\n" + 
				"             !! ! !|[]_|\r\n" + 
				"             !!!._|_[]\r\n" + 
				"             !!!|!_.[]\r\n" + 
				"             !|!_!__[]!.\r\n" + 
				"             !_!_!__[]! !.\r\n" + 
				"             !_!_!__[]! ! `.\r\n" + 
				"              |!_!__|]! ! ! `.\r\n" + 
				"               |_!__|]! ! ! ! `.\r\n" + 
				"                 |____|_! ! ! !  `\r\n" + 
				"                   |____|_! ! ! !\r\n" + 
				"                    []____|_! ! !\r\n" + 
				"                    []______|_! !\r\n" + 
				"                    []________|_!\r\n" + 
				"  __________________[]__________|____________________");
		
		try {
			Thread.sleep(750);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(lastRefresh);
	}

	public static void atticAnimation() {
		try {
			Thread.sleep(750);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(refresh);

		System.out.println("     __________\r\n" + 
				"    /`.`^%===_/\r\n" + 
				"    `. `\\ \r\n" + 
				"      `. `. \r\n" + 
				"        `./");

		try {
			Thread.sleep(750);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(refresh);

		System.out.println("     __________\r\n" + 
				"    /|________/\r\n" + 
				"   | |\r\n" + 
				"   | |\r\n" + 
				"   | |\r\n" + 
				"   | |\r\n" + 
				"   |/  ");
		
		try {
			Thread.sleep(750);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(lastRefresh);
	}
}
