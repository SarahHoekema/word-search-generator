package WordSearch;

import java.util.*;

public class WordSearchSolution extends WordSearchBase{
	//fields
	char[][] solution;
	
	//constructor
	public WordSearchSolution(WordSearchBase game) {
		super(game.getWords(), game.getDimensions());	
		solution = Arrays.copyOf(game.getWordSearch(), getDimensions());
	}
	
	//generate the word search solution
	public void generate() {
		for(int i = 0; i < solution.length; i++) {
			for(int j = 0; j < solution[i].length; i++) {
				if(solution[i][j] == 0) {
					solution[i][j] = 'X';
				}
			}
		}
	}
}
