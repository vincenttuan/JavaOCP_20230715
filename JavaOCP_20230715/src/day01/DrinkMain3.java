package day01;

public class DrinkMain3 {

	public static void main(String[] args) {
		Drink d1 = new Drink("tea", "紅茶", 10);
		Drink d2 = new Drink("tea", "綠茶", 12);
		Drink d3 = new Drink("tea", "青茶", 15);
		
		// 客戶點餐
		Drink[] drinks = {d1, d1, d2, d2, d2, d3, d3, d3, d3, d2, d2, d1};
		
		// 列印飲料單(逐筆印出每一筆飲料)
		System.out.println("飲料單:");
		System.out.println("-------------------------------------");
		int sum = 0;
		for(Drink drink : drinks) {
			System.out.println(drink);
			sum += drink.price;
		}
		System.out.println("-------------------------------------");
		// 列印總金額
		System.out.printf("總金額: $%d\n", sum);
		
		// 請問平均一杯飲料多少錢 ?
		int avg = sum / drinks.length;
		System.out.printf("平均每杯: $%d\n", avg);
	}

}
