package day05;

// 物件導向:飲料設計圖
public class Drink {
	
	String name; // 飲料名
	int price; // 飲料價格
	
	// 顯示飲料的方法
	void display() {
		System.out.printf("%s $%d\n", name, price);
	}
	
}
