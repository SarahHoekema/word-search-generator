package WordSearch;

import java.util.*;

public class WordSearchGame extends WordSearchBase{
	//fields
	private char[][] game;
	
	//constructor
	public WordSearchGame(WordSearchBase base) {
		super(base.getWords(), base.getDimensions());
		this.game = new char[base.getDimensions()][base.getDimensions()];
		generate();
	}
	
	//generates a word search game
	public void generate(){
		char[][] base = super.getWordSearch();
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
	
	//toString method	
		public String toString() {
			String s = "";
			for(int i = 0; i < game.length; i++) {
				for(int j = 0; j < game[i].length; j++) {
					s += game[i][j] + "  ";
				}
				s += "\n";
			}
			s += "\n" + super.getWords().get(0) + "    ";
			for(int i = 1; i < super.getWords().size(); i++) {
				s += super.getWords().get(i) + "    ";
				if(i%6 == 0) {
					s += "\n";
				}
			}
			s += "\n";
			return s;
		}

}
