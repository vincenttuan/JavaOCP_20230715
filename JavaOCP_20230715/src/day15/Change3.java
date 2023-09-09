package day15;

import java.util.Random;
import java.util.Scanner;

public class Change3 {
	
	// 定義一個 Money 這個 enum 來代表各種紙鈔與硬幣的面值
	enum Money {
		NOTE_500(500), NOTE_100(100), // 紙鈔
		COIN_50(50), COIN_10(10), COIN_5(5), COIN_1(1); // 硬幣
		
		private final int value;
		
		private Money(int value) {
			this.value = value;
		}
		
		public int getValue() {
			return value;
		}
	}
	
	static class Tx { // 交易
		private final int price;
		private int amount;
		
		Tx(int price, int amount) {
			this.price = price;
			this.amount = amount;
			System.out.println();
		}
		
		public int getChange() {
			return amount - price;
		}
		
		void printChangeDetail() {
			int change = getChange();
			System.out.printf("找零金額: $%d\n", change);
			for(Money money : Money.values()) {
				int count = change / money.getValue();
				change = change % money.getValue();
				System.out.printf("%d元 %d 個\n", money.getValue(), count);
			}
		}
		
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("商品金額:");
		int price = new Random().nextInt(100) + 1; // 1~100
		System.out.println(price);
		
		System.out.print("請輸入付款金額:");
		int amount = scanner.nextInt();
		
		//--------------------------------------------------------------
		
		// 計算找零金額
		Tx tx = new Tx(price, amount); // 注入商品價格與付款金額
		//Tx tx2 = new Tx(52, 100); // 注入商品價格與付款金額
		tx.printChangeDetail();
		//tx2.printChangeDetail();
		System.out.println(tx);
		//System.out.println(tx2);

	}

}
