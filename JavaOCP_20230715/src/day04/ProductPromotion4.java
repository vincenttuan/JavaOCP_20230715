package day04;

public class ProductPromotion4 {

	public static void main(String[] args) {
		// 1. 飲料上架
		Drink drinkA = new Drink("A", 20);
		Drink drinkB = new Drink("B", 15);
		
		// 2. 促銷活動
		Promotion promotionA = new Promotion(drinkA, 3, 1);
		Promotion promotionB = new Promotion(drinkB, 1, 1);
		
		// 3. 購買
		int totalPriceForA = promotionA.calcuateTotalPrice(22);
		int totalPriceForB = promotionB.calcuateTotalPrice(11);
		int totalPrice = totalPriceForA + totalPriceForB;
		
		// 4. 結帳並印出資料
		PrintResult printResultA = new PrintResult(drinkA, promotionA, 22);
		PrintResult printResultB = new PrintResult(drinkB, promotionB, 11);
		printResultA.print();
		printResultB.print();
		
		System.out.printf("總共 %d\n", totalPrice);
		
		
		
	}

}
