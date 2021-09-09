public class Drawboard {
	 Drawboard(char[][] gameboard) {
		for(int i=0;i<gameboard.length;i++) {
			for(int j=0;j<gameboard[0].length;j++)
				System.out.print(gameboard[i][j]);
			System.out.println();
}
}
}
