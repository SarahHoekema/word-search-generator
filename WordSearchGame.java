//Sarah Hoekema
//CS 145
//November 8, 2022
//Assignment 1 - Word Search Generator

package WordSearch;

import java.util.*;

//WordSearchGame.java uses a WordSearchBase to create a word search with randomly
//generated Char values in place of the '0' null values
public class WordSearchGame{
	//fields
	private ArrayList<String> words;
	private char[][] base;
	private char[][] game;
	
	//constructor
	public WordSearchGame(WordSearchBase base) {
		this.base = base.getWordSearch();
		this.words = base.getWords();
		this.game = new char[base.getDimensions()][base.getDimensions()];
		generate();
	}
	
	//generates a word search game by filling '0' null values
	//with a randomly generated Char
	private void generate(){
		Random r = new Random();
		for(int i = 0; i < game.length; i++) {
			for(int j = 0; j < game[i].length; j++) {
				game[i][j] = base [i][j];
				if(game[i][j] == '0') {
					game[i][j] = (char) ('A' + r.nextInt(26));
				}
			}
		}
	}
	
	//returns a String representation of the word search game
		public String toString() {
			String s = "\n";
			for(int i = 0; i < game.length; i++) {
				for(int j = 0; j < game[i].length; j++) {
					s += game[i][j] + "  ";
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
