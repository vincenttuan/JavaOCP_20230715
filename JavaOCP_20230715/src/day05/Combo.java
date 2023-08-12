package day05;

import java.util.Optional;

//物件導向: 套餐設計圖
public class Combo {
	private static final double RATE = 0.8;
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
		calculatePrice(); // 計算套餐價格
	}
	
	// 飲料 + 麵包
	public Combo(String name, Drink drink, Bread bread) {
		this(name, drink, bread, null);
	}
	
	// 飲料 + 蛋糕
	public Combo(String name, Drink drink, Cake cake) {
		this(name, drink, null, cake);
	}
	
	// 計算套餐價格的方法
	private void calculatePrice() {
		int total = drink.getPrice();
		
		// 若 bread 不是 null 就得到 bread 的 price 反之得到 0
		total += Optional.ofNullable(bread).map(Bread::getPrice).orElse(0);
		total += Optional.ofNullable(cake).map(Cake::getPrice).orElse(0);
		/*
		if(bread != null) {
			total += bread.getPrice();
		}
		if(cake != null) {
			total += cake.getPrice();
		}
		*/
		
		total = (int)(total * RATE);
		setPrice(total);
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
		if(drink != null) {
			this.drink = drink;
			calculatePrice(); // 計算套餐價格
		}
	}

	public Bread getBread() {
		return bread;
	}

	public void setBread(Bread bread) {
		if(bread != null) {
			this.bread = bread;
			calculatePrice(); // 計算套餐價格
		}
	}

	public Cake getCake() {
		return cake;
	}

	public void setCake(Cake cake) {
		if(cake != null) {
			this.cake = cake;
			calculatePrice(); // 計算套餐價格
		}
	}
	
	public void display() { // 優化寫法
		StringBuilder sb = new StringBuilder();
		// 始終會顯示的部分
		sb.append(String.format("%s $%d 飲料:%s($%d) ", name, price, drink.getName(), drink.getPrice()));
		// 條件性顯示的部分
		Optional.ofNullable(bread).ifPresent(bread -> sb.append(String.format("麵包:%s($%d) ", bread.getName(), bread.getPrice())));
		Optional.ofNullable(cake).ifPresent(cake -> sb.append(String.format("蛋糕:%s($%d) ", cake.getName(), cake.getPrice())));
		/*
		if(bread != null) {
			sb.append(String.format("麵包:%s($%d) ", bread.getName(), bread.getPrice()));
		}
		if(cake != null) {
			sb.append(String.format("蛋糕:%s($%d) ", cake.getName(), cake.getPrice()));
		}
		*/
		System.out.println(sb);
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
