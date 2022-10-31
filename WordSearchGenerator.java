package WordSearch;

import java.util.*;

public class WordSearchGenerator {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		printIntro();
		printDirections();
		String option = "";
		do{
			//construct WordSearchBase
			option = input.next().toUpperCase();
			if(option.equals("G")){
				//prompt user for number of words
				//prompt user for each word
				//create WordEntry for each word
				//load each WordEntry into an ArrayList
				//determine dimensions
				//generate the WordSearchBase with ArrayList
				System.out.println("generate");
			} else if(option.equals("P")){
				//construct WordSearchGame with WordSearchBase
				//print WordSearchGame
				//throw an error message if there is no current word search
				System.out.println("print");
			} else if(option.equals("S")){
				//construct WordSearchSolution with WordSearchBase
				//print WordSearchSolution
				//throw an error message if there is no current word search
				System.out.println("solution");
			} else if(option.equals("D")){
				printDirections();
			} else if(option.equals("Q")) {
				printOutro();
			} else{
				System.out.println("Sorry, that input isn't valid. Please try again.");
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
		System.out.println("Please enter in the letter of one of options below:");
		System.out.println("-Generate a new word search (G)");
		System.out.println("-Print out the word search (P)");
		System.out.println("-Show the solution to the word search (S)");
		System.out.println("-Show the directions (D)");
		System.out.println("-Quit the program (Q)");
		System.out.println();
	}
	
	//prints the outro to the word search generator
	public static void printOutro() {
		System.out.println("Thank you for using the word search generator.");
		System.out.println("Come back soon!");
	}
}