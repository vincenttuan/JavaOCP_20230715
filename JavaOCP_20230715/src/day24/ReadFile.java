package day24;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile {

	public static void main(String[] args) {
		// 讀取 src\day24\john_salary.txt
		String filePath = "src/day24/john_salary.txt";
		try(FileInputStream fis = new FileInputStream(filePath)) {
			
			// 建立一個大小為 1024 字節的緩衝區用於讀取文件
			byte[] buffer = new byte[1024];
			int bytesRead = -1;
			
			// 讀取文件
			while ((bytesRead = fis.read(buffer)) != -1) {
				System.out.println(bytesRead);
				for(int i=0;i<bytesRead;i++) {
					System.out.print(buffer[i]+ " ");
				}
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
