package day10;

public abstract class Coffee {
 
	private String name;
	 
	private int price;
	 
	public Coffee(String name, int price) {
		setName(name);
		setPrice(price);
	}
	 
	public String getName() {
		return name;
	}
	 
	public void setName(String name) {
		this.name = name;
	}
	
	 
	public int getPrice() {
		return price;
	}
	 
	public void setPrice(int price) {
		this.price = price;
	}
	 
	public abstract void roastMethod();
}
 
