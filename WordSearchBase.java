package WordSearch;

import java.util.*;

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
	//TODO: make an algorithm to randomize word insertion
	private void generate() {
		Random r = new Random();
		//populate the 2D array with null values
		for(int i = 0; i < base.length; i++) {
			for(int j = 0; j < base[i].length; j++) {
				base[i][j] = '0';
			}
		}
		//traverse through words ArrayList to individually add each word
		for(String word : words) {
			String s = null;
			int xVal = 0;
			int yVal = 0;
			//select if reverse or not
			int reverse = r.nextInt(2);
			switch(reverse) {
			case 0:
				s = word;
				break;
			case 1:
				s = reverse(word);
				break;
			}
			
			//select direction of the word
			int direction = r.nextInt(3);
			
			//generates x and y values for the word until a suitable combo is found
			if(direction == 0) {
				do {
					xVal = r.nextInt(dimensions);
					yVal = r.nextInt(dimensions);					
				} while(!checkVertical(s, xVal, yVal));
			} else if (direction == 1){
				do {
					xVal = r.nextInt(dimensions);
					yVal = r.nextInt(dimensions);					
				} while(!checkHorizontal(s, xVal, yVal));
			} else {
				do {
					xVal = r.nextInt(dimensions);
					yVal = r.nextInt(dimensions);					
				} while(!checkDiagonal(s, xVal, yVal));
			}
			
			//add word into word search
			switch(direction) {
			case 0:	
				vertical(s, xVal, yVal);
				break;
			case 1:
				horizontal(s, xVal, yVal);
				break;
			case 2:
				diagonal(s, xVal, yVal);
				break;
			}
		}
	}
	
	//adds a word into the 2D array vertically
	private void vertical(String word, int xVal, int yVal) {
		for(int i = 0; i < word.length(); i++) {
			base[yVal][xVal] = word.charAt(i);
			yVal++;
		}		
	}
	
	//adds a word into the 2D array horizontally
	private void horizontal(String word, int xVal, int yVal) {
		for(int i = 0; i < word.length(); i++) {
			base[yVal][xVal] = word.charAt(i);
			xVal++;
		}	
	}
	
	//adds a word into the 2D array diagonally
	private void diagonal(String word, int xVal, int yVal) {
		for(int i = 0; i < word.length(); i++) {
			base[yVal][xVal] = word.charAt(i);
			xVal++;
			yVal++;
		}
	}
	
	//check if word can be added in vertically
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
	
	//check if word can be added in horizontally
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
	
	//check if word can be added in diagonally
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
	
	//reverses the provided word
	private String reverse(String word) {
		String s = "";
		for(int i = word.length()-1; i >= 0; i--) {
			s += word.charAt(i);
		}
		return s;
	}
	//toString method	
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
