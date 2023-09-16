package day17;

import java.time.LocalDate;

public class Transaction {
	private LocalDate date;
	private int qty;
	private Product product;
	private Location location;
	
	public Transaction(LocalDate date, int qty, Product product, Location location) {
		this.date = date;
		this.qty = qty;
		this.product = product;
		this.location = location;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Transaction [date=" + date + ", qty=" + qty + ", product=" + product + ", location=" + location + "]";
	}
	
}
