package day03;

import java.util.Arrays;

public class ArrayDemo1 {

	public static void main(String[] args) {
		// 一維靜態陣列
		int[] scores = new int[3];
		System.out.println("[" + scores[0] + ", " + scores[1] + ", " + scores[2] + "]");
		System.out.println(Arrays.toString(scores));
		System.out.println("陣列長度:" + scores.length);
		// 修改維度內容
		scores[0] = 100;
		scores[1] = 90;
		scores[2] = 80;
		//scores[3] = 70; // 超過 index 範圍
		System.out.println("[" + scores[0] + ", " + scores[1] + ", " + scores[2] + "]");
		System.out.println(Arrays.toString(scores));
		
	}

}
