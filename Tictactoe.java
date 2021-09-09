public class Tictactoe
 {

	static boolean isrunning = true;

	public static void main(String[] args) {
		while (true)
			if (isrunning) {
				System.out.println("-------------------");
				System.out.println("----Tic Tac Toe----");
				System.out.println("-------------------");
				System.out.printf("Score\tPlayer: %d\tCPU: %d\n", Score.playerscore, Score.cpuscore);
				new Drawboard(Gameboard.gameboard);
				new Playermove();
				System.out.println(Placepiece.playerpos);
				new Checkwinner();
				if (!isrunning)
					continue;
				new Cpumove();
				new Checkwinner();
			} else {
				new Drawboard(Gameboard.gameboard);
				@SuppressWarnings("resource")
				java.util.Scanner in = new java.util.Scanner(System.in);
				System.out.println("Restart ? (y/n)");
				String input = in.next();
				if (input.equalsIgnoreCase("y")) {
					isrunning = true;
					doRestart();
				} else if (input.equalsIgnoreCase("n")) {
					System.out.println("Thank you for playing!");
					System.exit(0);
				} else {
					System.out.println("Wrong input try again?");
				}
			}

	}

	// restart utility
	private static void doRestart() {
		Placepiece.cpupos.clear();
		Placepiece.playerpos.clear();
		Gameboard.clearBoard();
	}
}
