
public class Move {

	Move(char[][]gameboard, char symbol,int position){
		switch(position) {
		case 1:
			gameboard[1][3]=symbol;
			break;
		case 2:
			gameboard[1][7]=symbol;
			break;
		case 3:
			gameboard[1][11]=symbol;
			break;
		case 4:
			gameboard[3][3]=symbol;
			break;
		case 5:
			gameboard[3][7]=symbol;
			break;
		case 6:
			gameboard[3][11]=symbol;
			break;
		case 7:
			gameboard[5][3]=symbol;
			break;
		case 8:
			gameboard[5][7]=symbol;
			break;
		case 9:
			gameboard[5][11]=symbol;
			break;
			
		}
	}
	
Move(int move, char symbol){
	new Move(Gameboard.gameboard, symbol, move);
	
}

}
