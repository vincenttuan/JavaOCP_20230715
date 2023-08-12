package day05;

// 物件導向: 麵包設計圖
public class Bread {
	private String name; // 麵包名稱 
	private int price; // 麵包價格
	private double calories; // 麵包卡路里
	
	public Bread() {
		
	}
	
	public Bread(String name, int price, double calories) {
		setName(name);
		setPrice(price);
		setCalories(calories);
	}
	
	// 方法封裝
	
	// 設定麵包名稱
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public double getCalories() {
		return calories;
	}

	// 設定麵包價格
	public void setPrice(int price) {
		if(price >= 0 && price <=1000) {
			this.price = price;
		}
	}
	
	// 設定麵包熱量卡路里
	public void setCalories(double calories) {
		if(calories >= 0  && calories <= 500) {
			this.calories = calories;
		}
	}
	
	// 顯示麵包的方法
	void display() {
		System.out.printf("%s $%d %.1f卡\n", name, price, calories);
	}
}
