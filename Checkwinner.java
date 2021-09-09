import java.util.ArrayList;
import java.util.Arrays;

public class Checkwinner {
 Checkwinner(){
	 if(checkwinner().length()>0) {
		 System.out.println(checkwinner());
		 Tictactoe.isrunning = false;
	 }
 }



public String checkwinner() {
ArrayList<Integer[]>winning=new ArrayList<>();
	Integer[] toprow= {1, 2, 3};
	Integer[] midrow= {4, 5, 6};
	Integer[] botrow= {7, 8, 9};
	Integer[] rightcol= {1, 4, 7};
	Integer[] midcol= {2, 5, 8};
	Integer[] leftcol= {3, 6, 9};
	Integer[] diagonal1= {1, 5, 9};
	Integer[] diagonal2= {3, 5, 7};
    winning.add(toprow);
    winning.add(midrow);
    winning.add(botrow);
    winning.add(rightcol);
    winning.add(midcol);
    winning.add(leftcol);
    winning.add(diagonal1);
    winning.add(diagonal2);
    for(Integer[]win:winning) {
		if(Placepiece.playerpos.contains(win[0]))
			if(Placepiece.playerpos.contains(win[1]))
				if(Placepiece.playerpos.contains(win[2])) {
					Score.playerscore+=10;
    		        return "Great you've Won! with Line: "+ Arrays.toString(win);
				}
		if(Placepiece.cpupos.contains(win[0]))
			if(Placepiece.cpupos.contains(win[1]))
				if(Placepiece.cpupos.contains(win[2])) {
					Score.cpuscore+=10;
					return "Sorry CPU won! with Line: "+ Arrays.toString(win);
				}
		if(Placepiece.playerpos.size() + Placepiece.cpupos.size()==9)
					return  "CAT!";
           }
    return "";
	  }
 }

