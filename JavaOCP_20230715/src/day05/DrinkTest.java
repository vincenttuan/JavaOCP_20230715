package day05;

// 主程式
public class DrinkTest {

	public static void main(String[] args) {
		Drink drink1 = new Drink(); // 根據 Drink 的設計圖創建一個 Drink 飲料物件
		drink1.setName("舒跑");
		drink1.setPrice(25);
		
		Drink drink2 = new Drink("Fin", 20);
		
		drink1.display();
		drink2.display();
		
	}

}
