package WordSearch;

import java.util.*;
import java.util.regex.Pattern;

public class WordSearchGenerator {
	public static void main(String[] args) {
		//TODO: add comments
		Scanner input = new Scanner(System.in);
		String option = "";
		//construct WordSearchBase
		WordSearchBase base = null;
		WordSearchGame game = null;
		WordSearchSolution solution = null;
		
		printIntro();
		printDirections();
		do{
			//prompt for option
			System.out.print("Please enter a command: ");
			//read in option input
			option = input.next().toUpperCase();
			if(option.equals("G")){
				ArrayList<String> words = new ArrayList<String>();
				int dimensions = 0;
				
				//prompt user for number of words
				System.out.print("How many words would you like to enter? "); 
				int wordNum = input.nextInt();
				System.out.println("Please enter one word at a time:");
				//TODO: error handle incorrect input
				for(int i = 0; i < wordNum; i++) {
					//prompt for word
					System.out.print("Next word? ");
					//create WordEntry for each word
					String word = checkWord(input.next().toUpperCase(), input);
					//load each WordEntry into an ArrayList
					sortAndAddEntry(word, words);
					//determine dimensions
					if(word.length() > dimensions) {
						dimensions = word.length();
					}
				}
				System.out.println("Thanks for entering in your words!\n");
				
				//generate the WordSearchBase with ArrayList
				base = new WordSearchBase(words, dimensions*2);
				game = new WordSearchGame(base);
				solution = new WordSearchSolution(base);
			} else if(option.equals("P")){
				//throw an error message if there is no current word search
				if(game == null) {
					System.out.println("I'm sorry, you haven't generated a word search yet.\n");
				} else { //print WordSearchGame
					System.out.println(game);
				}
			} else if(option.equals("S")){
				//throw an error message if there is no current word search
				if(solution == null) {
					System.out.println("I'm sorry, you haven't generated a word search yet.\n");
				} else { //print WordSearchSolution
					System.out.println(solution);
				}
			} else if(option.equals("D")){
				printDirections();
			} else if(option.equals("Q")) {
				printOutro();
			} else{
				System.out.println("Sorry, that input isn't valid. Please try again.\n");
			}
		}while(!option.equals("Q"));
		
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
	
	//checks if the word entry is valid using the Pattern and Matcher classes
	public static String checkWord(String word, Scanner input) {
		if(Pattern.matches(".*[0-9\\W_].*", word)) {
			System.out.print("That word is invalid!! Please entry a new word: ");
			return checkWord(input.next().toUpperCase(), input);
		} else {
			return word;
		}
	}
	
	//sorts the word entry into the array by longest to shortest length
	public static void sortAndAddEntry(String entry, ArrayList<String> words) {
		if(words.size() == 0 || words.get(words.size()-1).length() > entry.length()) {
			words.add(entry);
		} else{
			for(int i = 0; i < words.size(); i++) {
				if(words.get(i).length() <= entry.length()) {
					words.add(i, entry);
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