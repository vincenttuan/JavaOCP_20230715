package day04;

/*
 * 仿造 ProductPromotion.java
 * 商品促銷
 * 假設 A 飲料 一瓶 20 元
 * 第二件 6 折
 * 請問買 11 瓶 A 飲料要多少錢 ?
 * */

public class ProductPromotion5 {
	public static void main(String[] args) {
		int bottlesToBuy = 11; // 要購買的瓶數
        int pricePerBottle = 20; // 每瓶飲料的價格
        double discount = 0.6; // 第二件的折扣率
        
        // 每一組的價格相加總
        int groupSize = 2;
        int groupAmount = bottlesToBuy / groupSize;
        int bottlesToPayForInGroups = (int)(groupAmount * ((1+discount) * pricePerBottle));
		
        // 剩餘加總
     	int remainingAmount = bottlesToBuy % groupSize; // 剩餘數量
     	int remainingBottlesToPayFor = remainingAmount * pricePerBottle; // 剩餘數量要付的費用 
     		
     	// 總計 
     	int totalPrice = bottlesToPayForInGroups + remainingBottlesToPayFor;
     	
     	System.out.printf("A 飲料一瓶 %d 元(第二件 %.0f 折), 買 %d 瓶共需 %d 元\n", 
				pricePerBottle, discount*10, bottlesToBuy, totalPrice);
		
	}
}
