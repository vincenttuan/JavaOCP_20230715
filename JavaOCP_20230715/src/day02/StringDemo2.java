package day02;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class StringDemo2 {

	public static void main(String[] args) throws IOException {
		// 利用 Scanner 將 股票庫存檔.txt 的字串抓出
		//File file = new File("src\\day02\\股票庫存檔.txt");
		//Scanner scanner = new Scanner(file);
		
		// 利用 Scanner 將網路上的 http://192.168.1.157:9090/java/股票庫存檔.txt 的字串抓出
		// "股票庫存檔" URL 的編碼 = %E8%82%A1%E7%A5%A8%E5%BA%AB%E5%AD%98%E6%AA%94
		URL url = new URL("http://192.168.1.157:9090/java/%E8%82%A1%E7%A5%A8%E5%BA%AB%E5%AD%98%E6%AA%94.txt");
		Scanner scanner = new Scanner(url.openStream());
		
		//------------------------------------------------------------------------------------------------------
		
		String allData = scanner.useDelimiter("\\A").next();
		System.out.println(allData);
		
	}

}
