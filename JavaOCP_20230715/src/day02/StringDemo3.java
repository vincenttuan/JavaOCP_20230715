package day02;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class StringDemo3 {

	public static void main(String[] args) throws IOException {
		// 1.檔案位置
		File file = new File("src/day02/股票庫存檔.txt");
		// 2.利用 Scanner 取得所有字串
		String allData = new Scanner(file).useDelimiter("\\A").next();
		//System.out.println(allData);

	}

}
