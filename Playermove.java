import java.util.Scanner;

public class Playermove {
	private int move;
	Scanner in;
	Playermove(){
		    if(Tictactoe.isrunning) {
		    in = new Scanner(System.in);
			System.out.println("Input your move?");
			setMove(in.nextInt());
			
			while(true) 
			if(!(Placepiece.playerpos.size() + Placepiece.cpupos.size()==9))
			if(Placepiece.playerpos.contains(getMove()) | Placepiece.cpupos.contains(getMove()))
			{
				System.out.println("Incorrect position try again! ");
				setMove(in.nextInt());
			}
			else 
				break;
			if(getMove() > 0 && getMove() < 10)
			    new Placepiece(getMove(), "user");
			else
				System.out.println("Chance lost");
		    }
		
		}

	public int getMove() {
		return move;
	}

	public void setMove(int move) {
		this.move = move;
	}
	}

