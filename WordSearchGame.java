package WordSearch;

import java.util.*;

public class WordSearchGame extends WordSearchBase {
	//fields
	char[][] game;
	
	//constructor
	public WordSearchGame(WordSearchBase base) {
		super(base.getWords(), base.getDimensions());	
		this.game = Arrays.copyOf(base.getWordSearch(), getDimensions());
	}
}
