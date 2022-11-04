//Sarah Hoekema
//CS 145
//November 8, 2022
//Assignment 1 - Word Search Generator

package WordSearch;

import java.util.ArrayList;

//WordSearchSolution.java uses a WordSearchBase to create a word search with 'X'
//in place of the '0' null values
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
	
	//generates a word search game by filling '0' null values
	//with a 'X' values
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
	
	//returns a String representation of the word search solution	
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
