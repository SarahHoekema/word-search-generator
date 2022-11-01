package WordSearch;

import java.util.*;

public class WordSearchSolution{
	//fields
	private ArrayList<WordEntry> words;
	char[][] solution;
	
	//constructor
	public WordSearchSolution(WordSearchBase base) {
		words = base.getWords();
		solution = base.getWordSearch().clone();
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
		s += "\n" + words.get(0) + "    ";
		for(int i = 1; i < words.size(); i++) {
			s += words.get(i) + "    ";
			if(i%6 == 0) {
				s += "\n";
			}
		}
		s += "\n";
		return s;
	}
}
