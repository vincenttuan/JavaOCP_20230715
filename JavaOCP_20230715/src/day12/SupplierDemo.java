package day12;

import java.sql.Connection;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import java.util.function.Supplier;

public class SupplierDemo {
	/*
	 * @FunctionalInterface
	 * public interface Supplier<T> {
	 *     T get();
	 * }
	 * 
	 * */
	public static void main(String[] args) {
		Supplier<Date> supplier = () -> new Date();
		System.out.printf("現在時刻 %s\n", supplier.get());
		
		Supplier<Connection> connectionSupplier = () -> {
			// ... 連接資料庫相關作業
			return null;
		};
		
		// Supplier<Integer[]> 產生一個 1~39 不重複的號碼共五個
		// 結果放到 Integer[] 中
		Supplier<Integer[]> lottoSupplier = () -> {
			return new Random().ints(1, 40)
					.distinct()  // 不重複
					.limit(5)  // 選五個
					.boxed() // 將 int 轉 Integer
					//.toArray(Integer[]::new);
					.toArray(size -> new Integer[size]);
		};
		
		System.out.println(Arrays.toString(lottoSupplier.get()));
		
	}

}
