package WordSearch;

public class WordSearchSolution extends WordSearchBase{
	//fields
	private char[][] solution;
	
	//constructor
	public WordSearchSolution(WordSearchBase base) {
		super(base.getWords(), base.getDimensions());
		solution = new char[base.getDimensions()][base.getDimensions()];
		generate();
	}
	
	//generate the word search solution
	private void generate() {
		char[][] base = super.getWordSearch();
		for(int i = 0; i < solution.length; i++) {
			for(int j = 0; j < solution[i].length; j++) {
				solution[i][j] = base[i][j];
				if(solution[i][j] == '0') {
					solution[i][j] = 'X';
				}
			}
		}
	}
	
	//toString method	
	public String toString() {
		String s = "\n";
		for(int i = 0; i < solution.length; i++) {
			for(int j = 0; j < solution[i].length; j++) {
				s += solution[i][j] + "  ";
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
