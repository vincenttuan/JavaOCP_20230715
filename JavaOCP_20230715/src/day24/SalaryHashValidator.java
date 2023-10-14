package day24;

public class SalaryHashValidator {

	public static void main(String[] args) {
		// 已知的 Hash
		String knowHash = "a257948db2c79ac48f4faa03f67bcd473b4a903a589ffd0c3566bc6a69105a25";
		
		
		// 針對 src\day24\john_salary.txt 產生 Hash code (雜湊值)
		// SHA-256 -> 32個字 -> 會轉成 64 個十六進位的字 (1個字2個十六進位字串表示) 
		String filePath = "src/day24/john_salary.txt";
		String fileHash = KeyUtil.generateFileHash(filePath);
		
		// 比較 knowHash == fileHash
		if(knowHash.equals(fileHash)) {
			System.out.printf("%s 是完整的\n", filePath);
		} else {
			System.out.printf("%s 可能已被修改或損壞\n", filePath);
		}
	}

}
