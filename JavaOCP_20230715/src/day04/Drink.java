package day04;

public class Drink {
	private String name;
	private int pricePerBottle;
	
	//------------------------------------------------
	
	public Drink(String name, int pricePerBottle) {
		this.name = name;
		this.pricePerBottle = pricePerBottle;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPricePerBottle() {
		return pricePerBottle;
	}

	public void setPricePerBottle(int pricePerBottle) {
		this.pricePerBottle = pricePerBottle;
	}
	
	
	
}
