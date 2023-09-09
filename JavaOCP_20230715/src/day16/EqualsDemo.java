package day16;

import java.util.Objects;

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
	public int hashCode() {
		return Objects.hash(name, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(name, other.name) && price == other.price;
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
		System.out.println(book1);
		System.out.println(book2);
		System.out.println(book1.hashCode());
		System.out.println(book2.hashCode());
		System.out.println(book1 == book2);
		System.out.println(book1.equals(book2));
		
	}
}
