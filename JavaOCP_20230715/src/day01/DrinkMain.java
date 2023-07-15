package day01;

public class DrinkMain {

	public static void main(String[] args) {
		Drink d1 = new Drink();
		d1.type = "tea";
		d1.name = "紅茶";
		d1.price = 10;
		d1.print();
		
		Drink d2 = new Drink("tea", "綠茶", 12);
		d2.print();
		

	}

}
