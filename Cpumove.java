
public class Cpumove {
	private int move;

	
	// using minimax algorithm
	Cpumove() {
		if (Tictactoe.isrunning) {
			setMove(determinePos(MiniMax.minimax(3, 'O')[1], MiniMax.minimax(3, 'O')[2]));
			while (true)
				if (!(Placepiece.playerpos.size() + Placepiece.cpupos.size() == 9))
					if (Placepiece.playerpos.contains(getMove()) || Placepiece.cpupos.contains(getMove())) {
						System.out.println("Incorrect position try again! ");
						setMove(determinePos(MiniMax.minimax(3, 'O')[1], MiniMax.minimax(3, 'O')[2]));
					} else
						break;
			if(getMove() > 0 && getMove() < 10){
			System.out.println(getMove());
			new Placepiece(getMove(), "cpu");
			}else{
				System.out.println("Incorrect position, chance lost");
			}
		}
	}
	
	public int getMove() {
		return move;
	}
	public void setMove(int move) {
		this.move = move;
	}
	private int determinePos(int row, int col){
		  int pos = 0;
		  switch (row){
		  case 1:
		     switch (col){
		     case 3:
		          pos = 1;
		          break;
		     case 7:
		          pos = 2;
		          break;
		     case 11:
		          pos = 3;
		          break;
		     default:
		    	 break;
	          }
		       break;
		  case 3:
		  switch (col){
		     case 3:
		          pos = 4;
		          break;
		     case 7:
		          pos = 5;
		          break;
		     case 11:
		          pos = 6;
		          break;
		     default:
		          break;
	          }
		     break;
		  case 5:
		  switch (col){
		     case 3:
		          pos = 7;
		          break;
		     case 7:
		          pos = 8;
		          break;
		     case 11:
		          pos = 9;
		          break;
		     default:
		          break;
	          }
		     break;
		  default:
		     break;
	      }
	      return  pos;
	   }
}
