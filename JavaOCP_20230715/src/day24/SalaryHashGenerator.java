package day24;

public class SalaryHashGenerator {

	public static void main(String[] args) {
		// 針對 src\day24\john_salary.txt 產生 Hash code (雜湊值)
		// SHA-256 -> 32個字 -> 會轉成 64 個十六進位的字 (1個字2個十六進位字串表示) 
		
		String filePath = "src/day24/john_salary.txt";
		
		String fileHash = KeyUtil.generateFileHash(filePath);
		
		System.out.printf("%s 的 SHA-256 Hash:\n%s\n", filePath, fileHash);
	}

}
