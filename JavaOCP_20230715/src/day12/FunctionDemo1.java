package day12;

import java.util.function.Function;

public class FunctionDemo1 {
	
	/*
	 * @FunctionalInterface
	 * public interface Function<T,R> {
	 *     R apply(T t);
	 * }
	 * 
	 * */
	
	public static void main(String[] args) {
		// 計算圓面積
		Function<Integer, Double> func1 = (r) -> r * r * 3.14;
		System.out.println(func1.apply(5));
		
		// 計算攝氏轉華氏
		Function<Integer, Double> func2 = (c) -> c * 9/5.0 + 32;
		System.out.println(func2.apply(25));
		
		// 計算BMI
		

	}

}
