package day03;

import java.util.Arrays;

public class ArrayDemo3 {

	public static void main(String[] args) {
		int[] scores = new int[]{100, 90, 80}; // 有初始值的陣列
		System.out.println(Arrays.toString(scores));
		// 若要多增加一個元素, 原陣列不可以直接增加必須重新指向新的陣列
		scores = new int[] {100, 90, 80, 70}; // 重新建立一個陣列
		System.out.println(Arrays.toString(scores));
	}

}
