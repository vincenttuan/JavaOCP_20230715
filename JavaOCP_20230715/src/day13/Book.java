package day13;

public class Book { // 書
	private String name; // 書名
	private BookTag tag;  // 標籤
	private int price; // 價格
	
	public Book(String name) {
		this.name = name;
	}
	
	public Book(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	public Book(String name, int price, BookTag tag) {
		this.name = name;
		this.price = price;
		this.tag = tag;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BookTag getTag() {
		return tag;
	}

	public void setTag(BookTag tag) {
		this.tag = tag;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return String.format("分類: %s 書名: %s 價格: %d", tag, name, price);
	}
}
