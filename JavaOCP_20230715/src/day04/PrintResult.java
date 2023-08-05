package day04;

// 專屬列印服務
public class PrintResult {
	private Drink drink;
	private Promotion promotion;
	private int bottlesToBuy;
	
	public PrintResult(Drink drink, Promotion promotion, int bottlesToBuy) {
		this.drink = drink;
		this.promotion = promotion;
		this.bottlesToBuy = bottlesToBuy;
	}

	public void print() {
		System.out.printf("%s 飲料一瓶 %d 元(買 %d 送 %d), 買 %d 瓶共需 %d 元\n", 
				drink.getName(), drink.getPricePerBottle(), promotion.getBuyNumber(), promotion.getFreeNumber(), 
				bottlesToBuy, promotion.getTotalPrice());
	}
	
}
