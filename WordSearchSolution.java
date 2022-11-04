package WordSearch;

import java.util.ArrayList;

public class WordSearchSolution {
	//fields
	private ArrayList<String> words;
	private char[][] base;
	private char[][] solution;
	
	//constructor
	public WordSearchSolution(WordSearchBase base) {
		this.base = base.getWordSearch();
		this.words = base.getWords();
		this.solution = new char[base.getDimensions()][base.getDimensions()];
		generate();
	}
	
	//generate the word search solution
	private void generate() {
		for(int i = 0; i < solution.length; i++) {
			for(int j = 0; j < solution[i].length; j++) {
				solution[i][j] = base[i][j];
				if(solution[i][j] == '0') {
					solution[i][j] = 'X';
				}
			}
		}
	}
	
	//toString method	
	public String toString() {
		String s = "\n";
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
