package WordSearch;

import java.util.*;

public class WordSearchBase {
	//fields
	private ArrayList<String> words;
	private char[][] wordSearch;
	
	
	//constructor
	public WordSearchBase(ArrayList<String> words) {
		this.words = new ArrayList<String>(words);
		//call generate method
	}
	
	//method to generate word search upon construction
	
	//toString method	
	
	//returns the words ArrayList
	public ArrayList<String> getWords(){
		return words;
	}
	
	//returns the wordSearch 2D array
	public char[][] getWordSearch(){
		return wordSearch;
	}
	
	//sets the words ArrayList
	public void setWords(ArrayList<String> words) {
		this.words = words;
	}
	
	//sets the wordSearch 2D array
	public void setWordSearch(char[][] wordSearch) {
		this.wordSearch = wordSearch;
	}
}
