package day01;

public class DrinkMain2 {

	public static void main(String[] args) {
		Drink d1 = new Drink("tea", "紅茶", 10);
		Drink d2 = new Drink("tea", "綠茶", 12);
		Drink d3 = new Drink("tea", "青茶", 15);
		
		// 將 d1, d2, d3 放到陣列中
		Drink[] drinks = {d1, d2, d3};
		
		// 印出所有飲料
		for(int i=0;i<drinks.length;i++) {
			System.out.println(drinks[i]);
		}
		System.out.println("-------------------------------------");
		
		for(Drink drink : drinks) {
			System.out.println(drink);
		}
		System.out.println("-------------------------------------");
		
		// 計算總和
		int sum = 0;
		for(int i=0;i<drinks.length;i++) {
			sum += drinks[i].price;
		}
		System.out.printf("總和=%d\n", sum);
		System.out.println("-------------------------------------");
		
		
	}

}
