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
class Book { // 書
	String name; // 書名
	String tag;  // 標籤
	Book(String name) {
		this.name = name;
	}
	void setTag(String tag) { // 設定標籤
		this.tag = tag;
	}
	@Override
	public String toString() {
		return String.format("分類: %s 書名: %s", tag, name);
	}
}

public class ConsumerDemo {
	
	public static void main(String[] args) {
		// 標籤機
		BiConsumer<Book, String> addTagBook = (book, tag) -> book.setTag(tag);
		// 書籍
		Book book1 = new Book("快快樂樂學程式");
		Book book2 = new Book("快快樂樂學電腦");
		Book book3 = new Book("台灣旅遊");
		// 想要針對某一本書貼上標籤分類
		addTagBook.accept(book1, "技術類");
		addTagBook.accept(book2, "技術類");
		addTagBook.accept(book3, "旅遊類");
		// 印出書籍資訊
		System.out.println(book1);
		System.out.println(book2);
		System.out.println(book3);
	}

}










