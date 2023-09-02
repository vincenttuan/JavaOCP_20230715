package day13;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

import static java.lang.System.out;

/********************************************************************************
 * Supplier, BiConsumer, BiPredicate, UnaryOperation (<-Function)
 * 1. Supplier:       提供書籍列表       Supplier<T>       不接受參數, 返回結果的類型是 T
 * 2. BiConsumer:     設定書的標籤       BiConsumer<T, U>  接受二個參數但不返回結果      
 * 3. BiPredicate:    過濾特定的標籤價格   BiPredicate<T, U> 接受二個參數並返回布林值
 * 4. UnaryOperation: 給予書籍特定的折扣   UnaryOperation<T> 接受一個參數與返回結果都是相同類型 T
 * @Author: abc
 * @version: 1.0
********************************************************************************/
public class IntegrateDemo2 {
	
	public static void main(String[] args) {
		// 1. Supplier: 提供書籍列表
		Supplier<List<Book>> bookSupplier = () -> Arrays.asList(
				new Book("快快樂樂學程式", 100),
				new Book("快快樂樂學電腦", 200),
				new Book("無痛學Python", 150),
				new Book("24天搞定Java", 120)
		);
		
		// 2. BiConsumer: 設定書的標籤
		BiConsumer<Book, BookTag> setBookTag = Book::setTag;
		
		// 3. BiPredicate: 過濾特定的標籤(技術類)價格(>=150)
		BiPredicate<Book, BookTag> filterTagAndPrice = 
				(book, tag) -> book.getTag() == tag && book.getPrice() >= 150;
		
		// 4. UnaryOperation: 給予書籍特定的折扣(打九折)
		UnaryOperator<Book> applyDiscount = book -> {
			int newPrice = (int)(book.getPrice() * 0.9);
			book.setPrice(newPrice);
			return book;
		};
				
		// 進行 Streram API 分析
		bookSupplier.get().stream()  // 從 Supplier 獲取書籍列表
			.peek(book -> setBookTag.accept(book, BookTag.技術類))
			.filter(book -> filterTagAndPrice.test(book, BookTag.技術類))
			.map(applyDiscount) // 使用 UnaryOperation 來折扣 
			.forEach(out::println); // 印出書籍資訊
		
	}

}
