//Sarah Hoekema
//CS 145
//November 8, 2022
//Assignment 1 - Word Search Generator

package WordSearch;

import java.util.*;

//WordSearchBase.java generates a base word search using the provided words and dimensions.
//The words are added into the word search in normal or reverse order or in vertical, horizontal,
//or diagonal direction. Any empty spaces in the word search are filled with '0' characters as
//null values.
public class WordSearchBase {
	//fields
	private ArrayList<String> words;
	private char[][] base;
	private int dimensions;
	
	
	//constructor
	public WordSearchBase(ArrayList<String> words, int dimensions) {
		this.words = new ArrayList<String>(words);
		this.base = new char[dimensions][dimensions];
		this.dimensions = dimensions;
		generate();
	}
	
	//method to generate word search upon construction
	private void generate() {
		//constructs Random to randomize word reversal and direction
		Random r = new Random();
		
		//populates the 2D array with '0' characters as null values
		for(int i = 0; i < base.length; i++) {
			for(int j = 0; j < base[i].length; j++) {
				base[i][j] = '0';
			}
		}
		//traverses through each word in the ArrayList and adds into the word search
		for(String word : words) {
			//initializes to null values
			String s = null;
			int xVal = 0;
			int yVal = 0;
			
			//randomizes if the word is reversed or not
			int reverse = r.nextInt(2);
			switch(reverse) {
			case 0:
				s = word;
				break;
			case 1:
				s = reverse(word);
				break;
			}
			
			//selects the direction of the word
			int direction = r.nextInt(3);
			
			//generates x and y values for the word until a usuable coordinates are found
			//for the word
			if(direction == 0) { //vertical 
				do {
					xVal = r.nextInt(dimensions);
					yVal = r.nextInt(dimensions);					
				} while(!checkVertical(s, xVal, yVal));
			} else if (direction == 1){ //horizontal
				do {
					xVal = r.nextInt(dimensions);
					yVal = r.nextInt(dimensions);					
				} while(!checkHorizontal(s, xVal, yVal));
			} else { //diagonal
				do {
					xVal = r.nextInt(dimensions);
					yVal = r.nextInt(dimensions);					
				} while(!checkDiagonal(s, xVal, yVal));
			}
			
			//adds the word into the 2D array after suitable coordinates are found
			switch(direction) {
			case 0:	//vertical
				vertical(s, xVal, yVal);
				break;
			case 1: //horizontal
				horizontal(s, xVal, yVal);
				break;
			case 2: //diagonal
				diagonal(s, xVal, yVal);
				break;
			}
		}
	}
	
	//accepts a word and an x and y value as parameters
	//adds a word into the 2D array vertically
	private void vertical(String word, int xVal, int yVal) {
		for(int i = 0; i < word.length(); i++) {
			base[yVal][xVal] = word.charAt(i);
			yVal++;
		}		
	}
	
	//accepts a word and an x and y value as parameters
	//adds a word into the 2D array horizontally
	private void horizontal(String word, int xVal, int yVal) {
		for(int i = 0; i < word.length(); i++) {
			base[yVal][xVal] = word.charAt(i);
			xVal++;
		}	
	}
	
	//accepts a word and an x and y value as parameters
	//adds a word into the 2D array diagonally
	private void diagonal(String word, int xVal, int yVal) {
		for(int i = 0; i < word.length(); i++) {
			base[yVal][xVal] = word.charAt(i);
			xVal++;
			yVal++;
		}
	}
	
	//accepts a word and an x and y value as parameters
	//checks if word can be added in vertically
	//returns true if the word can be added and false it not
	private boolean checkVertical(String word, int xVal, int yVal) {
		if(xVal + word.length() > dimensions ||
		   yVal + word.length() > dimensions) {
			return false;
		}
		for(int i = 0; i < word.length(); i++) {
			if(base[yVal][xVal] != '0' && base[yVal][xVal] != word.charAt(i)) {
				return false;
			}
			yVal++;
		}	
		return true;
	}
	
	//accepts a word and an x and y value as parameters
	//check if word can be added in horizontally
	//returns true if the word can be added and false it not
	private boolean checkHorizontal(String word, int xVal, int yVal) {
		if(xVal + word.length() > dimensions ||
		   yVal + word.length() > dimensions) {
			return false;
		}
		for(int i = 0; i < word.length(); i++) {
			if(base[yVal][xVal] != '0' && base[yVal][xVal] != word.charAt(i)) {
				return false;
			}
			xVal++;
		}	
		return true;
	}
	
	//accepts a word and an x and y value as parameters
	//check if word can be added in diagonally
	//returns true if the word can be added and false it not
	private boolean checkDiagonal(String word, int xVal, int yVal) {
		if(xVal + word.length() > dimensions ||
		   yVal + word.length() > dimensions) {
			return false;
		}
		for(int i = 0; i < word.length(); i++) {
			if(base[yVal][xVal] != '0' && base[yVal][xVal] != word.charAt(i)) {
				return false;
			}
			xVal++;
			yVal++;
		}
		return true;
	}
	
	//accepts a word as a parameter
	//reverses the provided word
	//returns the reversed word
	private String reverse(String word) {
		String s = "";
		for(int i = word.length()-1; i >= 0; i--) {
			s += word.charAt(i);
		}
		return s;
	}
	//returns a String representation of the word search base	
	public String toString() {
		String s = "\n";
		for(int i = 0; i < base.length; i++) {
			for(int j = 0; j < base[i].length; j++) {
				s += base[i][j] + "  ";
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
	
	//returns the words ArrayList
	public ArrayList<String> getWords(){
		return words;
	}
	
	//returns the base 2D array
	public char[][] getWordSearch(){
		return base;
	}
	
	//returns the dimensions of the word search
	public int getDimensions(){
		return dimensions;
	}
}
