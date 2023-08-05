package day04;

// 專屬列印服務
public class PrintResult {
	private Promotion promotion;
	
	public PrintResult(Promotion promotion) {
		this.promotion = promotion;
	}

	public void print() {
		System.out.printf("%s 飲料一瓶 %d 元(買 %d 送 %d), 買 %d 瓶共需 %d 元\n", 
				promotion.getDrink().getName(), promotion.getDrink().getPricePerBottle(), 
				promotion.getBuyNumber(), promotion.getFreeNumber(), 
				promotion.getBottlesToBuy(), promotion.getTotalPrice());
	}
	
}
