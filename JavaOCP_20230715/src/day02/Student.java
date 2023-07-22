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

	@Override
	public String toString() {
		return "Student [NAME=" + NAME + ", SCORE1=" + SCORE1 + ", SCORE2=" + SCORE2 + ", SCORE3=" + SCORE3 + "]";
	}
	
	
	
}
