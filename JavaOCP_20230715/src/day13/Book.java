package day13;

public class Book { // 書
	String name; // 書名
	BookTag tag;  // 標籤
	int price; // 價格
	
	Book(String name) {
		this.name = name;
	}
	
	Book(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	Book(String name, int price, BookTag tag) {
		this.name = name;
		this.price = price;
		this.tag = tag;
	}
	
	void setTag(BookTag tag) { // 設定標籤
		this.tag = tag;
	}
	void setPrice(int price) { // 設定價格
		this.price = price;
	}
	@Override
	public String toString() {
		return String.format("分類: %s 書名: %s 價格: %d", tag, name, price);
	}
}
