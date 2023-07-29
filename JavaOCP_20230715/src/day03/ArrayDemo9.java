package day03;

import java.util.Arrays;
import java.util.stream.IntStream;

/*
給你一個整數陣列 arr，請找出陣列中的最小偶數並回傳，如果沒有任何偶數，請回傳 "null"。
要求：
你需要用兩種方法來解決這個問題：
方法一：使用傳統的 for-loop 來解決。
方法二：使用 Java 8 的 IntStream 來解決。

輸入：
arr = {1, 5, 6, 2, 3}
輸出：
最小偶數: 2

輸入：
arr = {1, 3, 5, 7, 9}
輸出：
最小偶數: null

提示：
你可以使用條件判斷式來判斷一個數是不是偶數。
你可以使用 Math.min 或 IntStream.min 來找出陣列中的最小值。
在使用 IntStream 時，記得過濾掉奇數，並在沒有偶數的情況下設定適當的回傳值。
*/

public class ArrayDemo9 {

	public static void main(String[] args) {
		//int[] arr = {1, 5, 6, 2, 3};
		int[] arr = {1, 3, 5, 7, 9};
		System.out.println("arr:" + Arrays.toString(arr));
		// 找出最小偶數
		int minEven = Integer.MAX_VALUE; // int 的最大值
		for(int num : arr) {
			if(num % 2 == 0 && num < minEven) {
				minEven = num;
			}
		}
		System.out.println("最小偶數:" + (minEven == Integer.MAX_VALUE?"null":minEven));
		
		// 使用 java Stream
		minEven = IntStream.of(arr)
				.filter(num -> num % 2 == 0)
				.min()
				.orElse(Integer.MAX_VALUE);
		
		System.out.println("最小偶數:" + (minEven == Integer.MAX_VALUE?"null":minEven));
		
	}

}
