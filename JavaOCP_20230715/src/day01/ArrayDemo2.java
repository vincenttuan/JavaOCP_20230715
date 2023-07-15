package day01;

import java.util.Arrays;

public class ArrayDemo2 {

	public static void main(String[] args) {
		int[] scores = {100, 40, 80, 70, 35};
		// 印出所有成績 for-loop
		for(int i=0;i<scores.length;i++) {
			System.out.println(scores[i]);
		}
		System.out.println("-------");
		// 印出所有成績 for-each
		for(int score : scores) {
			System.out.println(score);
		}
		System.out.println("-------");
		// 印出所有成績 Arrays.toString()
		System.out.println(Arrays.toString(scores));

	}

}
