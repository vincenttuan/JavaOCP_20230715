package day15;

import java.util.Random;
import java.util.Scanner;

public class Change4 {
	
	// 定義一個 Money 這個 enum 來代表各種紙鈔與硬幣的面值(value)與數量(count)
	enum Money {
		NOTE_500(500, 10), NOTE_100(100, 20), // 紙鈔
		COIN_50(50, 30), COIN_10(10, 0), COIN_5(5, 50), COIN_1(1, 60); // 硬幣
		
		private final int value; // 面值
		private int count;       // 數量
		
		private Money(int value, int count) {
			this.value = value;
			this.count = count;
		}
		
		public int getValue() {
			return value;
		}
		
		public int getCount() {
			return count;
		}
		
		public void deductCount(int num) { // 扣除(deduct)指定數量
			this.count -= num;
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
				// 判斷是否有足夠的零錢可以找
				if(count > money.getCount()) {
					System.out.printf("Sorry %d 元不夠了無法找\n", money.getValue());
					continue;
				}
				change = change % money.getValue();
				money.deductCount(count); // 扣除(deduct)指定數量
				System.out.printf("%d元 %d 個 (剩餘 %d 個)\n", 
						money.getValue(), count, money.getCount());
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
		tx.printChangeDetail();

	}

}
