package day04;

/*
 * 商品促銷
 * 假設 A 飲料 一瓶 20 元
 * 買 3 送 1
 * 假設 B 飲料 一瓶 15 元
 * 買 1 送 2
 * 請問買 22 瓶 A 飲料要多少錢 ?
 * 請問買 11 瓶 B 飲料要多少錢 ?
 * */
public class ProductPromotion2 {

	public static void main(String[] args) {
		String drinkName = "A";
		int bottlesToBuy = 22; // 總共要買的數量
		
		int pricePerBottle = 20; // A飲料每瓶價格
		int buyNumber = 3; // 買的數量
		int freeNumber = 1; // 送的數量
		
		// 每一組的價格相加總
		int groupSize = buyNumber + freeNumber;
		int groupAmount = bottlesToBuy / groupSize;
		int bottlesToPayForInGroups = groupAmount * (buyNumber * pricePerBottle);
		
		// 剩餘加總
		int remainingAmount = bottlesToBuy % groupSize; // 剩餘數量
		int remainingBottlesToPayFor = remainingAmount * pricePerBottle; // 剩餘數量要付的費用 
		
		// 總計 
		int totalPrice = bottlesToPayForInGroups + remainingBottlesToPayFor;
		
		System.out.printf("%s 飲料一瓶 %d 元(買 %d 送 %d), 買 %d 瓶共需 %d 元\n", 
				drinkName, pricePerBottle, buyNumber, freeNumber, bottlesToBuy, totalPrice);
		
	}

}
