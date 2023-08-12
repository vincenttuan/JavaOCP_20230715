package day05;

//物件導向: 套餐設計圖
public class Combo {
	private String name; // 套餐名稱
	private int price;   // 套餐價格
	private Drink drink; // 套餐飲料
	private Bread bread; // 套餐麵包
	private Cake cake;   // 套餐蛋糕
	
	
	public void display() {
		System.out.printf("%s $%d 飲料:%s 麵包:%s 蛋糕:%s\n", name, price, drink.getName(), bread.getName(), cake.getName());
	}
	
}
