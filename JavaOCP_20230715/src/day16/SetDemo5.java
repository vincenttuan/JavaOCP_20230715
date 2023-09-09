package day16;

import java.util.Set;
import java.util.TreeSet;

public class SetDemo5 {

	public static void main(String[] args) {
		// 能夠放在 TreeSet 裡的元素物件都要實作 Comparable
		// 以利 TreeSet 作為擺放元素邏輯使用
		Set<Integer> scores = new TreeSet<>();
		scores.add(90);
		scores.add(100);
		scores.add(80);
		System.out.println(scores); // 80, 90, 100
		
		Set<Book> books = new TreeSet<>();
		books.add(new Book("Java", 400));
		books.add(new Book("Python", 300));
		books.add(new Book("CPP", 200));
		books.add(new Book("VB", 250));
		System.out.println(books);
		
		
	}

}
