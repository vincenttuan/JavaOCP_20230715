package day06;

public class FoodTest {

	public static void main(String[] args) {
		// 設定主餐
		MainCourse noodles = new MainCourse("排骨麵", 115, "炸");
		MainCourse rice = new MainCourse("雞腿飯", 128, "滷");
		// 設定附餐
		SideDish soup = new SideDish("玉米湯", 50, false);
		SideDish tea = new SideDish("紅茶", 20, true);
		
		// 印出餐點
		System.out.println(noodles);
		System.out.println(rice);
		System.out.println(soup);
		System.out.println(tea);
		
		// 請結帳
		int total = noodles.getPrice() + rice.getPrice() + soup.getPrice() + tea.getPrice();
		System.out.printf("結帳 %d\n", total);
		
		Food[] foods = {noodles, rice, soup, tea};
		int total2 = 0;
		for(Food food : foods) {
			total2 += food.getPrice();
		}
		System.out.printf("結帳 %d\n", total2);
		
		

	}

}
