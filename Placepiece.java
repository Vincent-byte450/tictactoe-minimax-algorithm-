import java.util.ArrayList;

public class Placepiece {
	public static ArrayList<Integer>playerpos=new ArrayList<>();
	public static ArrayList<Integer>cpupos=new ArrayList<>();
	Placepiece(){}
	Placepiece(int move, String user){
		
		char symbol ='X';
		if(user == "user") {
			playerpos.add(move);
		}
		else if(user == "cpu") {
			symbol='O';
			cpupos.add(move);
		}
			new Move(move, symbol);
	}

}
