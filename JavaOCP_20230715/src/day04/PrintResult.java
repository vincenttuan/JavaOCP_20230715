package day04;

// 專屬列印服務
public class PrintResult {
	private Drink drink;
	private Promotion promotion;
	private int bottlesToBuy;
	private int totalPrice;
	
	public PrintResult(Drink drink, Promotion promotion, int bottlesToBuy, int totalPrice) {
		this.drink = drink;
		this.promotion = promotion;
		this.bottlesToBuy = bottlesToBuy;
		this.totalPrice = totalPrice;
	}

	public void print() {
		System.out.printf("%s 飲料一瓶 %d 元(買 %d 送 %d), 買 %d 瓶共需 %d 元\n", 
				drink.getName(), drink.getPricePerBottle(), promotion.getBuyNumber(), promotion.getFreeNumber(), 
				bottlesToBuy, totalPrice);
	}
	
}
