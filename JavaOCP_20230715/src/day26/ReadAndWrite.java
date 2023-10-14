package day26;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class ReadAndWrite {

	public static void main(String[] args) throws IOException {
		// Java 11: Files.writeString(), Files.readString()
		String filePath = "src/day26/data.txt";
		String data = "Hello Java 11";
		
		Path path = Path.of(filePath);
		if(Files.notExists(path)) {
			Files.createFile(path); // 建立檔案
		}
		
		// 寫入
		Files.writeString(path, data, StandardOpenOption.WRITE);
		
		// 讀取
		String content = Files.readString(path);
		System.out.println(content);
	}

}
