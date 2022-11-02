package WordSearch;

import java.util.*;

public class WordSearchBase {
	//fields
	private ArrayList<WordEntry> words;
	private char[][] base;
	private int dimensions;
	
	
	//constructor
	public WordSearchBase(ArrayList<WordEntry> words, int dimensions) {
		this.words = new ArrayList<WordEntry>(words);
		this.base = new char[dimensions][dimensions];
		this.dimensions = dimensions;
		generate();
	}
	
	//method to generate word search upon construction
	//TODO: make an algorithm to randomize word insertion
	private void generate() {
		//vertical word
//		for(int i = 0; i < words.size(); i++) {
//			String word = words.get(i).toString();
//			for(int  j= 0; j < word.length(); j++) {
//				base[j][i] = word.charAt(j);
//			}
//		}
		//horizontal word
//		for(int i = 0; i < words.size(); i++) {
//			String word = words.get(i).toString();
//			for(int j = 0; j < word.length(); j++) {
//				base[i][j] = word.charAt(j);
//			}
//		}
		//reverse vertical word
//		for(int i = 0; i < words.size(); i++) {
//			String temp = words.get(i).toString();
//			String word = "";
//			for(int j = temp.length()-1; j>=0; j--) {
//				word+=temp.charAt(j);
//			}
//			for(int  j= 0; j < word.length(); j++) {
//				base[j][i] = word.charAt(j);
//			}
//		}
		//reverse horizontal word
//		for(int i = 0; i < words.size(); i++) {
//			String temp = words.get(i).toString();
//			String word = "";
//			for(int j = temp.length()-1; j>=0; j--) {
//				word+=temp.charAt(j);
//			}
//			for(int j = 0; j < word.length(); j++) {
//				base[i][j] = word.charAt(j);
//			}
//		}
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
	public ArrayList<WordEntry> getWords(){
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
