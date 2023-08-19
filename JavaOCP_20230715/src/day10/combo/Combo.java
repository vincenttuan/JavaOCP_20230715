package day10.combo;

import day10.Cake;
import day10.Coffee;

// 組合餐
public class Combo {
	private String name;
	private Cake cake;
	private Coffee coffee;
	
	public Combo(String name) {
		setName(name);
	}
	
	public Combo(String name, Cake cake, Coffee coffee) {
		setName(name);
		setCake(cake);
		setCoffee(coffee);
	}

	public String getName() {
		return name;
	}
	
	// 外界不可修改名字
	private void setName(String name) {
		this.name = name;
	}

	public Cake getCake() {
		return cake;
	}
	
	// 只有與 Combo 在同一資料夾(package)的才可以存取
	void setCake(Cake cake) {
		this.cake = cake;
	}

	public Coffee getCoffee() {
		return coffee;
	}

	public void setCoffee(Coffee coffee) {
		this.coffee = coffee;
	}
	
	
	
}
