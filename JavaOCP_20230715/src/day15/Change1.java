package day15;

import java.util.Random;
import java.util.Scanner;

public class Change1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("商品金額:");
		int price = new Random().nextInt(100) + 1; // 1~100
		System.out.println(price);
		
		System.out.print("請輸入付款金額:");
		int amount = scanner.nextInt();
		
		// 計算找零金額
		int change = amount - price;
		System.out.printf("找零金額: $%d\n", change);
		
		// 計算每個銅板(50, 10, 5, 1)各要找幾個 ?
		// 可以利用 / 與 % 來計算出
		int coin50 = change / 50; // 計算出要找幾個 50 元硬幣
		change = change % 50;     // 找完 50 元後還省下多少錢要找
		int coin10 = change / 10; // 計算出要找幾個 10 元硬幣
		change = change % 10;     // 找完 10 元後還省下多少錢要找
		int coin5  = change / 5;  // 計算出要找幾個 5 元硬幣;
		change = change % 5;      // 找完 5 元後還省下多少錢要找
		int coin1  = change;      // 最後剩下的就是 1 元
		System.out.printf("50元 %d 個\n", coin50);
		System.out.printf("10元 %d 個\n", coin10);
		System.out.printf(" 5元 %d 個\n", coin5);
		System.out.printf(" 1元 %d 個\n", coin1);
	}

}
