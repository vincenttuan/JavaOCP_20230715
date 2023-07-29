package day03;

import java.util.stream.IntStream;

public class ArrayDemo8 {
	public static void main(String[] args) {
		int[] arr = {1, 5, 7, 2, 4};
		// 請找出最大奇數
		int maxOdd = 0;
		for(int num : arr) {
			if(num > maxOdd) {
				maxOdd = num;
			}
		}
		System.out.println("最大奇數:" + maxOdd);
		
		// 使用 Java IntSream 來解題
		maxOdd = IntStream.of(arr)
						  .filter(num -> num % 2 != 0)
						  .max()
						  .getAsInt();  // 將取到的最大值轉 int
		System.out.println("最大奇數:" + maxOdd);
	}
}
