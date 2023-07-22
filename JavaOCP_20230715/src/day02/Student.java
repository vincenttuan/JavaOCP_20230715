package day02;

public class Student {
	public final String NAME;
	public final String SCORE1;
	public final String SCORE2;
	public final String SCORE3;
	
	public Student(String nAME, String sCORE1, String sCORE2, String sCORE3) {
		super();
		NAME = nAME;
		SCORE1 = sCORE1;
		SCORE2 = sCORE2;
		SCORE3 = sCORE3;
	}
	
	// 逐漸進步
	public boolean isImproving() {
		int score1 = Integer.parseInt(SCORE1);
		int score2 = Integer.parseInt(SCORE2);
		int score3 = Integer.parseInt(SCORE3);
		
		return score1 < score2 && score2 < score3;
	}
	
	// 逐漸退步
	public boolean isDeclining() {
		int score1 = Integer.parseInt(SCORE1);
		int score2 = Integer.parseInt(SCORE2);
		int score3 = Integer.parseInt(SCORE3);
		
		return score1 > score2 && score2 > score3;
	}

	@Override
	public String toString() {
		return "Student [NAME=" + NAME + ", SCORE1=" + SCORE1 + ", SCORE2=" + SCORE2 + ", SCORE3=" + SCORE3 + "]";
	}
	
}
