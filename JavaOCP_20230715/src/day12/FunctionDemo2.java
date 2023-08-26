package day12;

import java.util.Arrays;
import java.util.function.Function;

public class FunctionDemo2 {

	public static void main(String[] args) {
		String[] names = {"John", "Alice", "Jo", "Bob", "Vincent"};
		// 請透過 Function 印出每一個字串的長度
		// 可以利用 map(Function) 來進行資料轉換
		// 可以利用 forEach(Consumer) 印出每一筆紀錄
		Function<String, Integer> getNameLength = name -> name.length();
		
		Arrays.stream(names)       // "John", "Alice", "Jo", "Bob", "Vincent"
			  .map(getNameLength)  // 4, 5, 2, 3, 7  <- 每一個都是 Integer
			  .forEach(System.out::println);
		
		// 平均名字有幾個字
		double avgLength = Arrays.stream(names)
								 //.mapToInt(name -> name.length()) // 4, 5, 2, 3, 7  <- int
								 .mapToInt(String::length) // 4, 5, 2, 3, 7  <- int
								 .average()
								 .orElse(0); // 如果沒有元素則返回 0
		System.out.println(avgLength);
	}

}
