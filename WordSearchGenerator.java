//Sarah Hoekema
//CS 145
//November 8, 2022
//Assignment 1 - Word Search Generator

package WordSearch;

import java.util.*;
import java.util.regex.Pattern;

//WordSearchGenerator.java is a word search generator that creates a word search with
//user provided words and prints the game and solution to the word search when prompted.
//Classes used include the WordSearchBase, WordSearchGame, WordSearchSolution, Scanner,
//Pattern, and Matcher classes. Use of the Pattern and Matcher classes was inspired by
//this Stack Overflow discussion: https://stackoverflow.com/questions/18590901/
//check-and-extract-a-number-from-a-string-in-java
public class WordSearchGenerator {
	public static void main(String[] args) {
		//declares variables and constructs objects
		Scanner input = new Scanner(System.in);
		String option = "";
		WordSearchBase base = null;
		WordSearchGame game = null;
		WordSearchSolution solution = null;
		
		//prints intro
		printIntro();
		//prints directions
		printDirections();
		
		do{
			//prompts for option
			System.out.print("Please enter a command: ");
			//reads in option input
			option = input.next().toUpperCase();
			
			if(option.equals("G")){
				//constructs ArrayList for words and int for word search dimensions
				ArrayList<String> words = new ArrayList<String>();
				int dimensions = 0;
				
				//prompts for number of words in word search
				int wordNum = promptWordNum(input);
				
				//prompts for words and populates the ArrayList each word
				dimensions = enterWords(words, dimensions, wordNum, input);
				
				//generates the WordSearchBase, WordSearchGame, and WordSearchSolution
				base = new WordSearchBase(words, dimensions*2);
				game = new WordSearchGame(base);
				solution = new WordSearchSolution(base);
			} else if(option.equals("P")){
				//prints an error message if there is no current word search
				if(game == null) {
					System.out.println("I'm sorry, you haven't generated a word search yet.\n");
				} else { //prints WordSearchGame
					System.out.println(game);
				}
			} else if(option.equals("S")){
				//prints an error message if there is no current word search
				if(solution == null) {
					System.out.println("I'm sorry, you haven't generated a word search yet.\n");
				} else { //prints WordSearchSolution
					System.out.println(solution);
				}
			} else if(option.equals("D")){
				//prints directions
				printDirections();
			} else if(option.equals("Q")) {
				//prints outro
				printOutro();
			} else{
				//prints error message for invalid input
				System.out.println("Sorry, that input isn't valid. Please try again.\n");
			}
		}while(!option.equals("Q"));
		
		//closes Scanner
		input.close();
	}
	
	//prints out an introduction to the word search generator
	public static void printIntro() {
		System.out.println("Welcome to the word search generator, brought to you by Sarah Hoekema");
		System.out.println("This program will generate and print a word search puzzle and its solution");
		System.out.println("for you to enjoy!");
		System.out.println();
	}
	
	//prints out the directions to the word search generator
	public static void printDirections() {
		System.out.println("Command options:");
		System.out.println("-Generate a new word search (G)");
		System.out.println("-Print out the word search (P)");
		System.out.println("-Show the solution to the word search (S)");
		System.out.println("-Show the directions (D)");
		System.out.println("-Quit the program (Q)");
		System.out.println();
	}
	
	//accepts a Scanner for input as a parameter
	//prompt for the user for the number of words in the word search and prints an
	//error message if the number is higher than 100
	//returns the number of words
	public static int promptWordNum(Scanner input) {
		//prompt user for number of words
		System.out.print("How many words would you like to enter? "); 
		int wordNum = input.nextInt();
		//check that number of words is capped at 100 words
		while(wordNum > 100) {
			System.out.println("Sorry, that's too many words!");
			System.out.print("Please enter a number lower than 100: ");
			wordNum = input.nextInt();
		}
		return wordNum;
	}
	
	//accepts an ArrayList of words, an int for dimensions and number of words,
	//and a Scanner for input as parameters
	//prompts user for each word, calls checkWord to check for their validity,
	//calls sortAndAddWord to sort and add each word to an ArrayList<String>,
	//and determines the dimensions of the word search
	//returns the dimensions
	public static int enterWords(ArrayList<String> words, int dimensions,
		int wordNum, Scanner input) {
		System.out.println("Please enter one word at a time:");
		for(int i = 0; i < wordNum; i++) {
			//prompt for word
			System.out.print("Next word? ");
			//create WordEntry for each word
			String word = checkWord(input.next().toUpperCase(), input);
			//load each WordEntry into an ArrayList
			sortAndAddWord(word, words);
			//determine dimensions
			if(word.length() > dimensions) {
				dimensions = word.length();
			}
		}
		System.out.println("Thanks for entering in your words!\n");
		return dimensions;
	}
	
	//accepts a String word and a Scanner for input as parameters
	//checks if the word entry is valid (not containing digits or special characters
	//using the Pattern and Matcher classes
	//returns a valid word
	public static String checkWord(String word, Scanner input) {
		if(Pattern.matches(".*[0-9\\W_].*", word)) {
			System.out.print("That word is invalid!! Please entry a new word: ");
			return checkWord(input.next().toUpperCase(), input);
		} else {
			return word;
		}
	}
	
	//accepts a String word and the ArrayList of words as parameters
	//sorts the word into the ArrayList by longest to shortest length
	public static void sortAndAddWord(String word, ArrayList<String> words) {
		if(words.size() == 0 || words.get(words.size()-1).length() > word.length()) {
			words.add(word);
		} else{
			for(int i = 0; i < words.size(); i++) {
				if(words.get(i).length() <= word.length()) {
					words.add(i, word);
					break;
				}
			}
		}
	}
	
	//prints the outro to the word search generator
	public static void printOutro() {
		System.out.println("Thank you for using the word search generator.");
		System.out.println("Come back soon!");
	}
}