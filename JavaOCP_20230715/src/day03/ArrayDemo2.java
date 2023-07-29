package day03;

public class ArrayDemo2 {
	public static void main(String[] args) {
		int[] scores = {100, 90, 80}; // 有初始值的陣列
		
		// 利用 for-loop 檢視陣列元素
		for(int i=0;i<scores.length;i++) {
			System.out.println(scores[i]);
		}
		
		// 利用 for-each 檢視陣列元素 (自動尋訪每一個元素)
		for(int score : scores) {
			System.out.println(score);
		}
		
	}
}
