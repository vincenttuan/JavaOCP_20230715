package day14;

public class BookEqualsDemo {

	public static void main(String[] args) {
		Book book1 = new Book("Java", 100);
		Book book2 = new Book("Java", 100);
		System.out.println(book1);
		System.out.println(book2);
		System.out.println(book1 == book2);
		System.out.println(book1.equals(book2));

	}

}
