package day16;

// 物件內容間的比較
// 覆寫 equals
// 覆寫 hashCode

class Book {
	private String name;
	private int price;
	
	Book(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Book [name=" + name + ", price=" + price + "]";
	}
}


public class EqualsDemo {
	public static void main(String[] args) {
		Book book1 = new Book("Java", 100);
		Book book2 = new Book("Java", 100);
		System.out.println(book1 == book2);
		System.out.println(book1.equals(book2));
		
	}
}
