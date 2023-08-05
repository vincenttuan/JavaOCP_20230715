package day04;

// 專屬列印服務
public class PrintResult {
	private Drink drink;
	private Promotion promotion;
	private int bottlesToBuy;
	
	public PrintResult(Promotion promotion, int bottlesToBuy) {
		this.promotion = promotion;
		this.bottlesToBuy = bottlesToBuy;
	}

	public void print() {
		System.out.printf("%s 飲料一瓶 %d 元(買 %d 送 %d), 買 %d 瓶共需 %d 元\n", 
				promotion.getDrink().getName(), promotion.getDrink().getPricePerBottle(), 
				promotion.getBuyNumber(), promotion.getFreeNumber(), 
				bottlesToBuy, promotion.getTotalPrice());
	}
	
}
