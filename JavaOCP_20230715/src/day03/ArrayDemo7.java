package day03;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ArrayDemo7 {

	public static void main(String[] args) {
		// 有一陣列 arr: [100, 52, 83, 40, 75]
		int[] arr = {100, 52, 83, 40, 75};
		System.out.println("arr:" + Arrays.toString(arr));
		// 我希望將 arr 中只留下及格且是5的倍數的成績
		
		arr = IntStream.of(arr)
					   .filter(num -> num >= 60 && num % 5 == 0)
					   .toArray();
		System.out.println("arr:" + Arrays.toString(arr));

	}

}
