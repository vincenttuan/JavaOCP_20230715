package day05;

// 測試 Bread 的程式
public class BreadTest {

	public static void main(String[] args) {
		Bread bread1 = new Bread();
		bread1.setName("冰火菠羅麵包");
		bread1.setPrice(50);
		bread1.setCalories(100.5);
		
		Bread bread2 = new Bread("熱狗麵包", 45, 88.5);
		
		bread1.display();
		bread2.display();

	}

}
