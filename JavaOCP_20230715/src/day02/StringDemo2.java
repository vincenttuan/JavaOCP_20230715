package day02;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Scanner;

public class StringDemo2 {

	public static void main(String[] args) throws IOException {
		// 利用 Scanner 將 股票庫存檔.txt 的字串抓出
		File file = new File("src\\day02\\股票庫存檔.txt");
		Scanner scanner = new Scanner(file);
		
		// 利用 Scanner 將網路上的 http://192.168.1.157:9090/java/股票庫存檔.txt 的字串抓出
		// "股票庫存檔" URL 的編碼 = %E8%82%A1%E7%A5%A8%E5%BA%AB%E5%AD%98%E6%AA%94
		//URL url = new URL("http://192.168.1.157:9090/java/%E8%82%A1%E7%A5%A8%E5%BA%AB%E5%AD%98%E6%AA%94.txt");
		//Scanner scanner = new Scanner(url.openStream());
		
		//------------------------------------------------------------------------------------------------------
		
		String allData = scanner.useDelimiter("\\A").next();
		System.out.println("字數:" + allData.length());
		// "\r\n" 是 windows 的標準換行符號
		// "\n" 是 Linux 的標準換行符號
		// "\r" 是 MacOS 的標準換行符號
		//String[] rows = allData.split("\r\n");
		String[] rows = allData.split(System.lineSeparator()); // 會根據當前的 OS 給予正確的換行符號
		System.out.println("筆數:" + rows.length);
		System.out.println("第1筆:"  + rows[0]);
		System.out.println("第2筆:"  + rows[1]);
		System.out.println("第10筆:" + rows[9]);
		System.out.println("最末筆:" + rows[rows.length - 1]);
		// 印出 rows 全部資料
		System.out.println("全部資料:" + Arrays.toString(rows));
		
		System.out.println("------------------------------------------------------------------------------------");
		//------------------------------------------------------------------------------------------------------
		// 將 rows 中的每一筆 data 轉 CBStock 物件以利後續分析
		for(String data : rows) {
			final String CB_TRAN_DATE        = data.substring(0, 0+7);
			final String CB_BROKER_ID        = data.substring(7, 7+4);
			final String CB_ACNO             = data.substring(11, 11+7);
			final String CB_COMPANY_NO       = data.substring(18, 18+6);
			final String CB_DEPT             = data.substring(24, 24+1);
			final String CB_UNSOLD_STOCK_NOS = data.substring(25, 25+12);
			final String CB_UNSOLD_COST      = data.substring(37, 37+14);
			final String CB_NOCOST_STOCK_NOS = data.substring(51, 51+12);
			// 將資料配置到 CBStock 物件中
			CBStock cbStock = new CBStock(CB_TRAN_DATE, CB_BROKER_ID, CB_ACNO, CB_COMPANY_NO, CB_DEPT, CB_UNSOLD_STOCK_NOS, CB_UNSOLD_COST, CB_NOCOST_STOCK_NOS);
			System.out.println(cbStock);
		}
		
		System.out.println("------------------------------------------------------------------------------------");
		
		// 將 rows 中的每一筆 data 轉 CBStock 物件以利後續分析
		for(int i=0;i<rows.length;i++) {
			String data = rows[i];
			final String CB_TRAN_DATE        = data.substring(0, 0+7);
			final String CB_BROKER_ID        = data.substring(7, 7+4);
			final String CB_ACNO             = data.substring(11, 11+7);
			final String CB_COMPANY_NO       = data.substring(18, 18+6);
			final String CB_DEPT             = data.substring(24, 24+1);
			final String CB_UNSOLD_STOCK_NOS = data.substring(25, 25+12);
			final String CB_UNSOLD_COST      = data.substring(37, 37+14);
			final String CB_NOCOST_STOCK_NOS = data.substring(51, 51+12);
			// 將資料配置到 CBStock 物件中
			CBStock cbStock = new CBStock(CB_TRAN_DATE, CB_BROKER_ID, CB_ACNO, CB_COMPANY_NO, CB_DEPT, CB_UNSOLD_STOCK_NOS, CB_UNSOLD_COST, CB_NOCOST_STOCK_NOS);
			System.out.println(cbStock);
		}
		
		
		
	}

}
