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
			for(int j = 0; j < solution[i].length; j++) {
				if(solution[i][j] == '0') {
					solution[i][j] = 'X';
				}
			}
		}
	}
	
	//toString method	
	public String toString() {
		String s = "";
		for(int i = 0; i < solution.length; i++) {
			for(int j = 0; j < solution[i].length; j++) {
				s += solution[i][j] + "  ";
			}
			s += "\n";
		}
		s += "\n" + super.getWords().get(0) + "    ";
		for(int i = 1; i < super.getWords().size(); i++) {
			s += super.getWords().get(i) + "    ";
			if(i%6 == 0) {
				s += "\n";
			}
		}
		s += "\n";
		return s;
	}
}
