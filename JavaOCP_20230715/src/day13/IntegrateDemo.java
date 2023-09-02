package day13;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

// Consumer, Predicate, Function 與 Supplier 整合應用
// 1. Supplier: 創建一個書籍列表
// 2. Predicate: 篩選某種標籤或是價格的書籍
// 3. Function: 轉換書籍的內容過格式
// 4. Consumer: 進行書籍的某些操作或印出
public class IntegrateDemo {

	public static void main(String[] args) {
		// 1. Supplier: 創建一個書籍列表
		Supplier<List<Book>> bookSupplier = () -> Arrays.asList(
				new Book("快快樂樂學程式", 100, BookTag.技術類),
				new Book("快快樂樂學電腦", 200, BookTag.技術類),
				new Book("台灣旅遊", 150, BookTag.旅遊類),
				new Book("生日蛋糕製作", 120, BookTag.美食類)
		);
		
		// 2. Predicate: 篩選價格超過 150 的書
		Predicate<Book> expensiveBooks = book -> book.getPrice() >= 150;
		
		// 3. Function: 轉換只包含書名與價格的字串
		Function<Book, String> bookToString = 
				book -> String.format("書名:%s 價格:%d", book.getName(), book.getPrice());
		
		// 4. Consumer: 印出書籍的字串資訊
		Consumer<String> printBookInto = str -> System.out.println(str);
		
		// 利用 Stream API 進行分析
		bookSupplier.get().stream()          // 從 Supplier 獲取書籍列表
					.filter(expensiveBooks)  // 使用 Predicate 進行過濾
					.map(bookToString)       // 使用 Function 進行轉換
					.forEach(printBookInto); // 使用 Consumer 進行操作
	}				

}
