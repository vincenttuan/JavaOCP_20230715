package day01;

public class DrinkMain4 {

	public static void main(String[] args) {
		Drink d1 = new Drink("tea", "紅茶", 10);
		Drink d2 = new Drink("tea", "綠茶", 12);
		Drink d3 = new Drink("tea", "青茶", 15);
		
		// 客戶點餐
		Drink[] drinks = {d1, d1, d2, d2, d2, d3, d3, d3, d3, d2, d2, d1};
		
		// 小計紅茶
		int sum1 = 0;    // 小計
		int amount1 = 0; // 杯數
		for(Drink drink : drinks) {
			if(drink.name.equals("紅茶")) {
				sum1 += drink.price;
				amount1++;
			}
		}
		System.out.printf("紅茶 %d 元 %d 杯 小計 %d 元\n", sum1/amount1, amount1, sum1);
		
		// 小計綠茶
		int sum2 = 0;    // 小計
		int amount2 = 0; // 杯數
		for(Drink drink : drinks) {
			if(drink.name.equals("綠茶")) {
				sum2 += drink.price;
				amount2++;
			}
		}
		System.out.printf("綠茶 %d 元 %d 杯 小計 %d 元\n", sum2/amount2, amount2, sum2);
		
		// 小計青茶
		int sum3 = 0;    // 小計
		int amount3 = 0; // 杯數
		for(Drink drink : drinks) {
			if(drink.name.equals("青茶")) {
				sum3 += drink.price;
				amount3++;
			}
		}
		System.out.printf("青茶 %d 元 %d 杯 小計 %d 元\n", sum3/amount3, amount3, sum3);

	}

}
