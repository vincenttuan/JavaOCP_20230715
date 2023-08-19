package day10;

public class Espresso extends Coffee {
 
	public Espresso(String name, int price) {
		super(name, price);
	}
	 
	public void roastMethod() {
		System.out.println("深度烘焙，使用少量水快速沖煮。");
	}
	 
}
 
