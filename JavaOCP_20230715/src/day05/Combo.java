package day05;

//物件導向: 套餐設計圖
public class Combo {
	
	private String name; // 套餐名稱
	private int price;   // 套餐價格 (drink.getPrice() + bread.getPrice() + cake.getPrice()) * 0.8
	private Drink drink; // 套餐飲料
	private Bread bread; // 套餐麵包
	private Cake cake;   // 套餐蛋糕
	
	// 飲料 + 麵包 + 蛋糕
	public Combo(String name, Drink drink, Bread bread, Cake cake) {
		setName(name);
		setDrink(drink);
		setBread(bread);
		setCake(cake);
		// 計算價格
		int price = (int)((drink.getPrice() + bread.getPrice() + cake.getPrice()) * 0.8);
		setPrice(price);
	}
	
	// 飲料 + 麵包
	public Combo(String name, Drink drink, Bread bread) {
		setName(name);
		setDrink(drink);
		setBread(bread);
		// 計算價格
		int price = (int)((drink.getPrice() + bread.getPrice()) * 0.8);
		setPrice(price);
	}
	
	// 飲料 + 蛋糕
	public Combo(String name, Drink drink, Cake cake) {
		setName(name);
		setDrink(drink);
		setCake(cake);
		// 計算價格
		int price = (int)((drink.getPrice() + cake.getPrice()) * 0.8);
		setPrice(price);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}
	
	// 不希望外界直接修改價格
	private void setPrice(int price) {
		this.price = price;
	}

	public Drink getDrink() {
		return drink;
	}

	public void setDrink(Drink drink) {
		this.drink = drink;
	}

	public Bread getBread() {
		return bread;
	}

	public void setBread(Bread bread) {
		this.bread = bread;
	}

	public Cake getCake() {
		return cake;
	}

	public void setCake(Cake cake) {
		this.cake = cake;
	}
	
	public void display() { // 優化寫法
		StringBuilder sb = new StringBuilder();
		// 始終會顯示的部分
		sb.append(String.format("%s $%d 飲料:%s($%d) ", name, price, drink.getName(), drink.getPrice()));
		// 條件性顯示的部分
		if(bread != null) {
			sb.append(String.format("麵包:%s($%d) ", bread.getName(), bread.getPrice()));
		}
		if(cake != null) {
			sb.append(String.format("蛋糕:%s($%d) ", cake.getName(), cake.getPrice()));
		}
	}
	
	/*
	public void display() {
		if(bread == null) {
			System.out.printf("%s $%d 飲料:%s($%d) 蛋糕:%s($%d)\n", 
					name, price, drink.getName(), drink.getPrice(), cake.getName(), cake.getPrice());
		} else if(cake == null) {
			System.out.printf("%s $%d 飲料:%s($%d) 麵包:%s($%d)\n", 
					name, price, drink.getName(), drink.getPrice(), bread.getName(), bread.getPrice());
		} else {
			System.out.printf("%s $%d 飲料:%s($%d) 麵包:%s($%d) 蛋糕:%s($%d)\n", 
					name, price, drink.getName(), drink.getPrice(), bread.getName(), bread.getPrice(), cake.getName(), cake.getPrice());
		}
	}
	*/
}
