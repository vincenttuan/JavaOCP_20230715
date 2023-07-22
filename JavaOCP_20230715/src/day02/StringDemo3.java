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
		System.out.println("字數:" + allData.length());
		// 3.利用 split() + 列分隔號 將每一筆資料放到字串陣列中
		String[] rows = allData.split(System.lineSeparator());
		System.out.println("rows 筆數(格式化前):" + rows.length);
		// 4.將每一筆字串經過欄位分析(請參考庫存格式.xls的定義)後將分析結果注入到 CBStock 物件中
		// 最後統一放在 CBStock[] 陣列內保存
		CBStock[] cbStocks = new CBStock[rows.length];
		// 利用 for-loop 逐筆加入
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
			// 將 cbStock 配置到指定陣列位置
			cbStocks[i] = cbStock;
		}
		System.out.println("cbStocks 筆數(格式化後):" + cbStocks.length);
		// 5.透過 cbStocks 陣列計算出所有庫存總和 
		int summary = 0;
		for(CBStock cbStock : cbStocks) {
			// 因為 cbStock.TOTAL_STOCK_NOS 是字串所以要用 Integer.parseInt() 轉型
			summary += Integer.parseInt(cbStock.TOTAL_STOCK_NOS);
		}
		System.out.printf("所有庫存總和: %,d 股\n", summary);
		System.out.printf("所有庫存總和: %,d 張\n", summary/1000);
	}

}
