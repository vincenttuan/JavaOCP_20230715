package day01;

public class DrinkMain5 {

	public static void main(String[] args) {
		Drink d1 = new Drink("tea", "紅茶", 10);
		Drink d2 = new Drink("tea", "綠茶", 12);
		Drink d3 = new Drink("tea", "青茶", 15);
		
		// 客戶點餐
		Drink[] drinks = {d1, d1, d2, d2, d2, d3, d3, d3, d3, d2, d2, d1};
		
		int sum1 = calcDrinkSumAndPrint("紅茶", drinks);
		int sum2 = calcDrinkSumAndPrint("綠茶", drinks);
		int sum3 = calcDrinkSumAndPrint("青茶", drinks);
		
		System.out.println("--------------------------------------");
		// 總金額
		int total = sum1 + sum2 + sum3;
		System.out.printf("總金額 %d 元\n", total);
	}
	
	// 計算小計與印出資料並回傳小計的方法
	public static int calcDrinkSumAndPrint(String drinkName, Drink[] drinks) {
		int sum = 0;    // 小計
		int amount = 0; // 杯數
		for(Drink drink : drinks) {
			if(drink.name.equals(drinkName)) {
				sum += drink.price;
				amount++;
			}
		}
		if(amount != 0) { 
			System.out.printf("%s %d 元 %d 杯 小計 %d 元\n", drinkName, sum/amount, amount, sum);
		}
		return sum;
	}

}
