package WordSearch;

public class WordEntry {
    //fields
    private static final int NUMBER_OF_LETTERS = 26;
    
    private String word;
    private int size;
    private int[] letterArray;

	//constructor for the letter inventory, string is inputed
	//letters are then counted based on occurance 
	public WordEntry(String input){
	    letterArray = new int[NUMBER_OF_LETTERS];
	    word = input.toUpperCase();
	    //loops through the string examining every letter
	    for (int i = 0; i < input.length(); i++){
	        //checks if it is a capital letter
	        if(input.charAt(i) >= 'A' && input.charAt(i) <= 'Z'){
	            //increases the value at a specific point in the array
	            letterArray[input.charAt(i) - 'A']++;
	            size++;
	        }
	    }
	}

	//accepts a char and returns the count,
	//if char is not letter throw IllegalArgumentException
	public int get(char letter){
	    letter = Character.toUpperCase(letter);
	    if(letter >= 'A' && letter <= 'Z'){
	        return letterArray[letter - 'A'];
	    } else {
	        throw new IllegalArgumentException();
	    }
	}
	
	//returns a String of the entry's word
	public String getWord() {
		return word;
	}

	//accepts a char and int and sets the new value,
	//if char is not letter throw IllegalArgumentException
	public void set(char letter, int value){
	    //if value is less than 0 letter become 'a' and if then statement evaluates false
	    letter = (value > 0) ? Character.toUpperCase(letter) : 'a';
	    if(letter >= 'A' && letter <= 'Z'){
	        //if value was smaller than previous entry, size decreases
	        size += value - letterArray[letter - 'A'];
	        letterArray[letter - 'A'] = value;
	    } else {
	        throw new IllegalArgumentException();
	    }
	}
	
	//returns the size of the entry
	public int size(){
	    return size;
	}
	
	//returns a boolean, true if letter array is empty
	public boolean isEmpty(){
	    return size == 0;
	}
	
	//returns a string of the letters sorted alphabetically
	//enclosed in brackets, all letters are lowercase 
	public String toString(){
		return word;
	}
}
