package day10;

public class Cappuccino extends Espresso {
 
	public Cappuccino(String name, int price) {
		super(name, price);
	}
	 
	public void roastMethod() {
		System.out.println("使用濃縮咖啡，加入打發的牛奶泡沫。");
	}
	 
}
 
