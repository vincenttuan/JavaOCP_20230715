package day10;

public class Latte extends Espresso {
	
	public Latte() {
		super("拿鐵咖啡", 50);
	}
	
	public Latte(String name, int price) {
		super(name, price);
	}
	 
	public void roastMethod() {
		System.out.println("使用濃縮咖啡，加入蒸汽牛奶。");
	}
	 
}
 
