package day01;

public class Drink {
	
	String type; // tea, milk 或 coffee
	String name; // 品名
	int price;   // 價格
	
	void print() {
		System.out.printf("type=%s name=%s price=%d\n", type, name, price);
	}
}
