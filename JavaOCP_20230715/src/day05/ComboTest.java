package day05;

public class ComboTest {

	public static void main(String[] args) {
		// 單點商品
		Drink coca = new Drink("可樂", 15);
		Drink orange = new Drink("柳橙汁", 25);
		Drink coffee = new Drink("咖啡", 35);
		
		Bread polo = new Bread("菠羅麵包", 35, 55.5);
		Bread hotdog = new Bread("熱狗麵包", 50, 78.5);
		Bread french = new Bread("法國麵包", 75, 30);
		
		Cake chocolate = new Cake("巧克力蛋糕", 55, 30);
		Cake strawberry = new Cake("草莓蛋糕", 45, 40);
		Cake cheese = new Cake("起司蛋糕", 65, 35);
		
		// 套餐
		Combo comboA = new Combo("A餐", coca, hotdog, chocolate);
		Combo comboB = new Combo("B餐", orange, polo);
		Combo comboC = new Combo("C餐", coffee, cheese);
		
		comboA.display();
		comboB.display();
		comboC.display();
		
		// 換餐點
		comboA.setDrink(coffee); // A 餐飲料換咖啡
		comboA.display();
		
		comboB.setCake(strawberry); // B 餐加點草莓蛋糕
		comboB.display();
	}

}
