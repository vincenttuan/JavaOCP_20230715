package day05;

// 物件導向:飲料設計圖
public class Drink {
	
	private String name; // 飲料名
	private int price; // 飲料價格
	
	public Drink() {
		
	}
	
	public Drink(String name, int price) {
		setName(name);
		setPrice(price);
	}
	
	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(int price) {
		if(price >= 0 && price <= 1000) {
			this.price = price;
		}
	}

	// 顯示飲料的方法
	public void display() {
		System.out.printf("%s $%d\n", name, price);
	}
	
}
