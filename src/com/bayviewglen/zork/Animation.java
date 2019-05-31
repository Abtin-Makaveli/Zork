package com.bayviewglen.zork;

public class Animation {
	private static String refresh = "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n";
	private static String lastRefresh = "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n";
	public static void doorAnimation() {
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
	
	public static void stairAnimation() {
		try {
			Thread.sleep(1000);
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
				"  ___ejm____________[]__________|____________________");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(refresh);
		
		System.out.println("____________________|__________][____________mje___  \r\n" + 
				"!_|________][                    \r\n" + 
				"! !_|______][                    \r\n" + 
				"! ! !_|____][                    \r\n" + 
				"! ! ! !_|____|                   \r\n" + 
				"`  ! ! ! !_|____|                 \r\n" + 
				".` ! ! ! !]|__!_|               \r\n" + 
				".` ! ! !]|__!_!|              \r\n" + 
				".` ! !][__!_!_!             \r\n" + 
				".! !][__!_!_!             \r\n" + 
				".!][__!_!|!             \r\n" + 
				"][._!|!!!             \r\n" + 
				"][_|_.!!!             \r\n" + 
				"|_][|! ! !!             \r\n" + 
				"|!_][ ! ! !              \r\n" + 
				"!__!_][ ! !,               \r\n" + 
				"|!__!_][ !,                 \r\n" + 
				"!_!__!_][,                   \r\n" + 
				"|!_!__!_][                    \r\n" + 
				"!_!_!_,__][                    \r\n" + 
				"_____!_____!_____!__!_!'_____][___!_____!_____!    \r\n" + 
				"!     !     !  ! !      ][   !     !     !    \r\n" + 
				"!     !     !  !,       ][   !     !     !    \r\n" + 
				"!     !     !  '        ][   !     !     !    \r\n" + 
				"_______________(        ][ )_______________   \r\n" + 
				"_________________         ][  _______________   \r\n" + 
				"][                    \r\n" + 
				"][                    \r\n" + 
				"][                    \r\n" + 
				"][                    \r\n" + 
				"][                    \r\n" + 
				"][                    ");
	}

	public static void atticAnimation() {
		
	}
}
