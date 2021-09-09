import java.util.*;

public class MiniMax {
	/**
	 * Recursive minimax at level of depth for either maximizing or minimizing
	 * player. Return int[3] of {score, row, col}
	 */
	public static int[] minimax(int depth, char player) {
		// Generate possible next moves in a List of int[2] of {row, col}.
		List<int[]> nextMoves = generateMoves();

		// mySeed is maximizing; while oppSeed is minimizing
		int bestScore = (player == 'O') ? Integer.MIN_VALUE : Integer.MAX_VALUE;
		int currentScore;
		int bestRow = -1;
		int bestCol = -1;

		if (nextMoves.isEmpty() || depth == 0) {
			// Gameover or depth reached, evaluate score
			bestScore = evaluate();
		} else {
			for (int[] move : nextMoves) {
				// Try this move for the current "player"
				Gameboard.gameboard[move[0]][move[1]] = player;
				if (player == 'O') { // mySeed (computer) is maximizing player
					currentScore = minimax(depth - 1, 'X')[0];
					if (currentScore > bestScore) {
						bestScore = currentScore;
						bestRow = move[0];
						bestCol = move[1];
					}
				} else { // oppSeed is minimizing player
					currentScore = minimax(depth - 1, 'O')[0];
					if (currentScore < bestScore) {
						bestScore = currentScore;
						bestRow = move[0];
						bestCol = move[1];
					}
				}
				// Undo move
				Gameboard.gameboard[move[0]][move[1]] = ' ';
			}
		}
		return new int[] { bestScore, bestRow, bestCol };
	}

	/**
	 * Find all valid next moves. Return List of moves in int[2] of {row, col} or
	 * empty list if gameover
	 */
	private static List<int[]> generateMoves() {
		List<int[]> nextMoves = new ArrayList<>(); // allocate List

		// If gameover, i.e., no next move
		if (Placepiece.playerpos.size() + Placepiece.cpupos.size() == 9) {
			return nextMoves; // return empty list
		}

		// Search for empty cells and add to the List
		for (int row = 1; row < Gameboard.gameboard.length; row++) {
			for (int col = 1; col < Gameboard.gameboard[1].length; col++) {
				if (Gameboard.gameboard[row][col] == ' ') {
					nextMoves.add(new int[] { row, col });
				}
			}
		}
		return nextMoves;
	}

	/**
	 * The heuristic evaluation function for the current board
	 * 
	 * @Return +100, +10, +1 for EACH 3-, 2-, 1-in-a-line for computer. -100, -10,
	 *         -1 for EACH 3-, 2-, 1-in-a-line for opponent. 0 otherwise
	 */
	private static int evaluate() {
		int score = 0;
		// Evaluate score for each of the 8 lines (3 rows, 3 columns, 2 diagonals)
		score += evaluateLine(1, 3, 1, 7, 1, 11); // row 0
		score += evaluateLine(3, 3, 3, 7, 3, 11); // row 1
		score += evaluateLine(5, 3, 5, 7, 5, 11); // row 2
		score += evaluateLine(1, 3, 3, 3, 5, 3); // col 0
		score += evaluateLine(1, 7, 3, 7, 5, 7); // col 1
		score += evaluateLine(1, 11, 3, 11, 5, 11); // col 2
		score += evaluateLine(1, 3, 3, 7, 5, 11); // diagonal
		score += evaluateLine(1, 11, 3, 7, 5, 3); // alternate diagonal
		return score;
	}

	/**
	 * The heuristic evaluation function for the given line of 3 cells
	 * 
	 * @Return +100, +10, +1 for 3-, 2-, 1-in-a-line for computer. -100, -10, -1 for
	 *         3-, 2-, 1-in-a-line for opponent. 0 otherwise
	 */
	private static int evaluateLine(int row1, int col1, int row2, int col2, int row3, int col3) {
		int score = 0;

		// First cell
		if (Gameboard.gameboard[row1][col1] == 'O') {
			score = 1;
		} else if (Gameboard.gameboard[row1][col1] == 'X') {
			score = -1;
		}

		// Second cell
		if (Gameboard.gameboard[row2][col2] == 'O') {
			if (score == 1) { // cell1 is mySeed
				score = 10;
			} else if (score == -1) { // cell1 is oppSeed
				return 0;
			} else { // cell1 is empty
				score = 1;
			}
		} else if (Gameboard.gameboard[row2][col2] == 'X') {
			if (score == -1) { // cell1 is oppSeed
				score = -10;
			} else if (score == 1) { // cell1 is mySeed
				return 0;
			} else { // cell1 is empty
				score = -1;
			}
		}

		// Third cell
		if (Gameboard.gameboard[row3][col3] == 'O') {
			if (score > 0) { // cell1 and/or cell2 is mySeed
				score *= 10;
			} else if (score < 0) { // cell1 and/or cell2 is oppSeed
				return 0;
			} else { // cell1 and cell2 are empty
				score = 1;
			}
		} else if (Gameboard.gameboard[row3][col3] == 'X') {
			if (score < 0) { // cell1 and/or cell2 is oppSeed
				score *= 10;
			} else if (score > 1) { // cell1 and/or cell2 is mySeed
				return 0;
			} else { // cell1 and cell2 are empty
				score = -1;
			}
		}
		return score;
	}
}
