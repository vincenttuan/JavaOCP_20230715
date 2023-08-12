package day05;

// 物件導向: 麵包設計圖
public class Bread {
	String name; // 麵包名稱 
	int price; // 麵包價格
	double calories; // 麵包卡路里
	
	// 顯示麵包的方法
	void display() {
		System.out.printf("%s $%d %.1f卡\n", name, price, calories);
	}
	
	
}
