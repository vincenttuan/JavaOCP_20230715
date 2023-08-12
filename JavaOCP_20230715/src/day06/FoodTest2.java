package day06;

public class FoodTest2 {

	public static void main(String[] args) {
		// 設定主餐
		MainCourse noodles = new MainCourse("排骨麵", 115, "炸");
		MainCourse rice = new MainCourse("雞腿飯", 128, "滷");
		// 設定附餐
		SideDish soup = new SideDish("玉米湯", 50, false);
		SideDish tea = new SideDish("紅茶", 20, true);
		
		// 點餐資料
		Food[] foods = {noodles, rice, soup, tea, noodles};
		
		// 印出餐點明細資料
		displayBillDetails(foods);
	}
	
	// 顯示明細
	public static void displayBillDetails(Food[] foods) {
		System.out.println("======================= 結帳明細 =======================");
		System.out.printf("%-10s %-4s %-4s %-4s\n", "品名", "單價", "數量", "小計");
		System.out.println("------------------------------------------------------");
		
		int subtotal = 0;
		for(Food food : foods) {
			System.out.printf("%-10s $%-4d\n", food.getName(), food.getPrice());
			subtotal += food.getPrice();
		}
		System.out.println("------------------------------------------------------");
		System.out.printf("%-10s $%-4d\n", "小計", subtotal);
		
		int tax = (int)(subtotal * 0.05); // 加上 5% 的稅
		System.out.printf("%-10s $%-4d\n", "稅", tax);
		
		int total = subtotal + tax;
		System.out.printf("%-10s $%-4d\n", "總計", total);
		System.out.println("======================================================");
	}
	

}
