package day02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StringDemo2 {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("C:\\Users\\MB-207\\eclipse-workspace\\JavaOCP_20230715\\src\\day02\\股票庫存檔.txt");
		// 利用 Scanner 將 股票庫存檔.txt 的字串抓出
		Scanner scanner = new Scanner(file);
		String allData = scanner.useDelimiter("\\A").next();
		System.out.println(allData);
		
	}

}
