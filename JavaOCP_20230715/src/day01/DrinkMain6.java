package day01;

public class DrinkMain6 {

	public static void main(String[] args) {
		Drink d1 = new Drink("tea", "紅茶", 10);
		Drink d2 = new Drink("tea", "綠茶", 12);
		Drink d3 = new Drink("tea", "青茶", 15);
		Drink d4 = new Drink("milk", "巧克力牛奶", 25);
		Drink d5 = new Drink("milk", "木瓜牛奶", 35);
		Drink d6 = new Drink("coffee", "拿鐵咖啡", 45);
		Drink d7 = new Drink("coffee", "焦糖咖啡", 55);
		Drink d8 = new Drink("coffee", "摩卡咖啡", 65);
		
		Drink[] drinks = {
				d1, d2, d3, d4, d5, d6, d7, d8,
				d1, d1, d1, d2, d2, d3, d3, d4,
				d4, d5, d6, d7, d8, d8, d1, d2,
				d1, d2, d3, d4, d5, d6, d7, d8,
		};
		
		
	}

}
