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
		
		// 4. 結帳
		System.out.printf("%s 飲料一瓶 %d 元(買 %d 送 %d), 買 %d 瓶共需 %d 元\n", 
				drinkA.getName(), drinkA.getPricePerBottle(), promotionA.getBuyNumber(), promotionA.getFreeNumber(), 
				22, totalPriceForA);
		
		System.out.printf("%s 飲料一瓶 %d 元(買 %d 送 %d), 買 %d 瓶共需 %d 元\n", 
				drinkB.getName(), drinkB.getPricePerBottle(), promotionB.getBuyNumber(), promotionB.getFreeNumber(), 
				11, totalPriceForB);
		
		System.out.printf("總共 %d\n", totalPrice);
		
		
		
	}

}
