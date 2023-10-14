package day24;

import java.io.FileReader;
import java.io.IOException;

public class ReadFile2 {

	public static void main(String[] args) {
		// 讀取 src\day24\john_salary.txt
		String filePath = "src/day24/john_salary.txt";
		
		try(FileReader fr = new FileReader(filePath)) {
			
			char[] buffer = new char[1024];
			int charsRead = -1;
			while((charsRead = fr.read(buffer)) != -1) {
				System.out.println("本次讀取" + charsRead + "個字");
				System.out.println(buffer);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
