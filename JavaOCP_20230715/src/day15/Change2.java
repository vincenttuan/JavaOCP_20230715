package day15;

import java.util.Random;
import java.util.Scanner;

// 透過 enum 來實現找零錢程式
public class Change2 {
	// 定義一個 Coin 這個 enum 來代表各種硬幣與面值
	enum Coin {
		COIN_50(50), COIN_10(10), COIN_5(5),COIN_1(1);
		
		private final int value;
		
		private Coin(int value) {
			this.value = value;
		}
		
		public int getValue() {
			return value;
		}
	}
	
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
		/*
		for(Coin coin : Coin.values()) {
			System.out.printf("%s %d\n", coin, coin.getValue());
		}
		*/
		for(Coin coin : Coin.values()) {
			int count = change / coin.getValue();
			change = change % coin.getValue();
			System.out.printf("%d元 %d 個\n", coin.getValue(), count);
		}
		

	}

}

