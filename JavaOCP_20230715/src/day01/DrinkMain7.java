package day01;

import static day01.DrinkMain5.calcDrinkSumAndPrint;

public class DrinkMain7 {

	public static void main(String[] args) {
		
		// 建立飲料名稱的陣列
		String[] drinkNames = {"紅茶", "綠茶", "青茶", "巧克力牛奶", "木瓜牛奶", "拿鐵咖啡", "焦糖咖啡", "摩卡咖啡", "濃縮咖啡"};
				
		// 建立飲料
		Drink d1 = new Drink("tea", "紅茶", 10);
		Drink d2 = new Drink("tea", "綠茶", 12);
		Drink d3 = new Drink("tea", "青茶", 15);
		Drink d4 = new Drink("milk", "巧克力牛奶", 25);
		Drink d5 = new Drink("milk", "木瓜牛奶", 35);
		Drink d6 = new Drink("coffee", "拿鐵咖啡", 45);
		Drink d7 = new Drink("coffee", "焦糖咖啡", 55);
		Drink d8 = new Drink("coffee", "摩卡咖啡", 65);
		Drink d9 = new Drink("coffee", "濃縮咖啡", 75);
		
		// 建立飲料單
		Drink[] drinks = {
				d1, d2, d3, d4, d5, d6, d7, d8,
				d1, d1, d1, d2, d2, d3, d3, d4,
				d4, d5, d6, d7, d8, d8, d1, d2,
				d1, d2, d3, d4, d5, d6, d7, d8,
		};
		
		
		int total = 0; // 總金額
		for(String drinkName : drinkNames) {
			int sum = calcDrinkSumAndPrint(drinkName, drinks);
			total += sum;
		}
		
		System.out.println("--------------------------------------");
		// 總金額
		System.out.printf("總金額 %d 元\n", total);
		
	}

}
