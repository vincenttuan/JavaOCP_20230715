package day13;

import java.util.function.BiConsumer;
import java.util.function.ObjIntConsumer;

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

public class ConsumerDemo {
	
	public static void main(String[] args) {
		// 標籤機
		BiConsumer<Book, BookTag> addTagBook = (book, tag) -> book.setTag(tag);
		// 價格設定
		ObjIntConsumer<Book> setBookPrice = (book, price) -> book.setPrice(price);
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
		// 將每一本書設定價格
		setBookPrice.accept(book1, 100);
		setBookPrice.accept(book2, 200);
		setBookPrice.accept(book3, 150);
		setBookPrice.accept(book4, 120);
		// 印出書籍資訊
		System.out.println(book1);
		System.out.println(book2);
		System.out.println(book3);
		System.out.println(book4);
	}

}










