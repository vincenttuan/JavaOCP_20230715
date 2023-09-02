package day13;

import java.util.function.BiConsumer;

/*

@FunctionalInterface
public interface Consumer<T> {
	void accept(T t);
}

@FunctionalInterface
public interface BiConsumer<T,U> {
	void accept(T t, U u)
}

*/

enum BookTag { // 書籍標籤
	技術類, 旅遊類, 美食類
}

class Book { // 書
	String name; // 書名
	BookTag tag;  // 標籤
	int price; // 價格
	Book(String name) {
		this.name = name;
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

public class ConsumerDemo {
	
	public static void main(String[] args) {
		// 標籤機
		BiConsumer<Book, BookTag> addTagBook = (book, tag) -> book.setTag(tag);
		// 書籍
		Book book1 = new Book("快快樂樂學程式");
		Book book2 = new Book("快快樂樂學電腦");
		Book book3 = new Book("台灣旅遊");
		Book book4 = new Book("生日蛋糕製作");
		// 想要針對某一本書貼上標籤分類
		addTagBook.accept(book1, BookTag.技術類);
		addTagBook.accept(book2, BookTag.技術類);
		addTagBook.accept(book3, BookTag.旅遊類);
		addTagBook.accept(book4, BookTag.美食類);
		// 印出書籍資訊
		System.out.println(book1);
		System.out.println(book2);
		System.out.println(book3);
		System.out.println(book4);
	}

}










