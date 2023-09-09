package day16;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

public class SetDemo4 {
	public static void main(String[] args) {
		Book book1 = new Book("Java", 400);
		Book book2 = new Book("Python", 300);
		Book book3 = new Book("CPP", 200);
		Book book4 = new Book("VB", 250);
		Book book5 = new Book("VB", 250);
		
		Set<Book> books = new LinkedHashSet<>();
		books.add(book1);
		books.add(book2);
		books.add(book3);
		books.add(book4);
		books.add(book5);
		
		System.out.println(books);
		System.out.println(books.size());
		
		// 計算總價
		int total = books.stream()
						 .mapToInt(Book::getPrice)
						 .sum();
		System.out.println(total);
		// 找出最貴的一本書 ?
		Optional<Book> bookOpt = books.stream()
									  .max((b1, b2) -> b1.getPrice() - b2.getPrice());
		if(bookOpt.isPresent()) { // 是否有找到
			Book book = bookOpt.get(); // 取出 book
			System.out.println(book);
		} else {
			System.out.println("無資料");
		}
		
		// 請問那一本書的書名比較短
		Optional<Book> shortBookOpt = books.stream()
				.min((b1, b2) -> Integer.compare(b1.getName().length(), b2.getName().length()));
		if(shortBookOpt.isPresent()) { // 是否有找到
			Book book = shortBookOpt.get(); // 取出 book
			System.out.println(book);
		} else {
			System.out.println("無資料");
		}
		
	}
}
