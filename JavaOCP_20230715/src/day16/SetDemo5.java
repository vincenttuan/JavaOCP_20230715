package day16;

import java.util.Set;
import java.util.SortedSet;
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
		
		TreeSet<Book> books = new TreeSet<>();
		books.add(new Book("Java", 400));
		books.add(new Book("Python", 300));
		books.add(new Book("CPP", 200));
		books.add(new Book("VB", 250));
		// 逆序查看-根據 price 由小到大
		System.out.println(books);
		
		// 最貴與最便宜的書
		System.out.println("最貴的書: " + books.last());
		System.out.println("最便宜的書: " + books.first());
		
		// 逆序查看-根據 price 由大到小
		System.out.println(books.descendingSet());
		
		// 金額大於等於 VB 的書
		System.out.println(books.tailSet(new Book("VB", 250)));
		
		
	}

}
