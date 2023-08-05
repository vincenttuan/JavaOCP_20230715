package day04;

public class Promotion {
	
	private Drink drink;
	private int buyNumber;
	private int freeNumber;
	
	// 計算優惠後的總價
	// bottlesToBuy 要買幾瓶
	public int calcuateTotalPrice(int bottlesToBuy) {
		int groupSize = buyNumber + freeNumber;
		int groupAmount = bottlesToBuy / groupSize;
		int bottlesToPayForInGroups = groupAmount * (buyNumber * drink.getPricePerBottle());
		
		int remainingAmount = bottlesToBuy % groupSize;
		int remainingBottlesToPayFor = remainingAmount * drink.getPricePerBottle();
		
		int totalPrice = bottlesToPayForInGroups + remainingBottlesToPayFor;
		return totalPrice;
	}
	
	//----------------------------------------------------------------------------------------
	
	public Promotion(Drink drink, int buyNumber, int freeNumber) {
		this.drink = drink;
		this.buyNumber = buyNumber;
		this.freeNumber = freeNumber;
	}

	public Drink getDrink() {
		return drink;
	}

	public void setDrink(Drink drink) {
		this.drink = drink;
	}

	public int getBuyNumber() {
		return buyNumber;
	}

	public void setBuyNumber(int buyNumber) {
		this.buyNumber = buyNumber;
	}

	public int getFreeNumber() {
		return freeNumber;
	}

	public void setFreeNumber(int freeNumber) {
		this.freeNumber = freeNumber;
	}
		
}
