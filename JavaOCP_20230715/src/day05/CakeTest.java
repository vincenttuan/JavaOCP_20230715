package day05;

//測試 Cake 的程式
public class CakeTest {

	public static void main(String[] args) {
		Cake cake1 = new Cake();
		cake1.setName("巧克力蛋糕");
		cake1.setPrice(65);
		cake1.setSweetRating(30);
		
		Cake cake2 = new Cake("起司蛋糕", 40, 45);
		
		cake1.display();
		cake2.display();

	}

}
