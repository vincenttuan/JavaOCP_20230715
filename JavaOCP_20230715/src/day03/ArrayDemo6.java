package day03;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ArrayDemo6 {

	public static void main(String[] args) {
		// 有一陣列 arr: [1, 2, 3, 4, 5]
		int[] arr = {1, 2, 3, 4, 5};
		System.out.println("arr:" + Arrays.toString(arr));
		// 我希望將 arr 中的偶數拿掉使 arr: [1, 3, 5]
		
		// 利用 Java IntStream 來過濾(filter)資料並創造新陣列(toArray)
		arr = IntStream.of(arr)  					// [1, 2, 3, 4, 5] 將一維陣列轉串流
					   .filter(num -> num % 2 != 0) // [1, 3, 5]
					   .toArray();
		
		System.out.println("arr:" + Arrays.toString(arr));
		
	}

}
