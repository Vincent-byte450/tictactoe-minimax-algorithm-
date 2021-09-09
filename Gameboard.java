
public class Gameboard {

   static char[][] gameboard = {
		    {' ','_','_','_','_','_','_','_','_','_','_','_','_','_',' '},
		    {' ','|',' ',' ',' ','|',' ',' ',' ','|',' ',' ',' ','|',' '},
		    {' ','|','_','_','_','|','_','_','_','|','_','_','_','|',' '},
		    {' ','|',' ',' ',' ','|',' ',' ',' ','|',' ',' ',' ','|',' '},
            {' ','|','_','_','_','|','_','_','_','|','_','_','_','|',' '},
            {' ','|',' ',' ',' ','|',' ',' ',' ','|',' ',' ',' ','|',' '},
            {' ','|','_','_','_','|','_','_','_','|','_','_','_','|',' '}
              };
   
   public static void clearBoard() {
	   for(int i=0;i<gameboard.length;i++) 
			for(int j=0;j<gameboard[0].length;j++)
			{
				if(gameboard[i][j] == 'X' || gameboard[i][j] == 'O')
					gameboard[i][j] = ' ';
				/*
				if(gameboard[i][j]==gameboard[1][3])
					gameboard[i][j] = ' ';
				if(gameboard[i][j]==gameboard[1][7])
					gameboard[i][j] = ' ';
				if(gameboard[i][j]==gameboard[1][11])
					gameboard[i][j] = ' ';
				if(gameboard[i][j]==gameboard[3][3])
					gameboard[i][j] = ' ';
				if(gameboard[i][j]==gameboard[3][7])
					gameboard[i][j] = ' ';
				if(gameboard[i][j]==gameboard[3][11])
					gameboard[i][j] = ' ';
				if(gameboard[i][j]==gameboard[5][3])
					gameboard[i][j] = ' ';
				if(gameboard[i][j]==gameboard[5][7])
					gameboard[i][j] = ' ';
				if(gameboard[i][j]==gameboard[5][11])
					gameboard[i][j] = ' ';
				*/
			}
	   
   }
            
}
