package day03;

import java.util.Arrays;

public class ArrayDemo4 {

	public static void main(String[] args) {
		int[] scores = new int[]{100, 90, 80}; // 有初始值的陣列
		System.out.println("scores:" + Arrays.toString(scores));
		// [100, 90, 80] 若要多增加一個元素 70 變成 [100, 90, 80, 70]
		int score = 70; // 希望能夠加入到 scores
		// 1. 創建一個新的陣列
		int[] newScores = new int[scores.length + 1];   // new int[4];
		System.out.println("newScores:" + Arrays.toString(newScores));
		// 2. 將 scores 陣列的原內容複製到 newScores 陣列中
		System.arraycopy(scores, 0, newScores, 0, scores.length);
		System.out.println("newScores:" + Arrays.toString(newScores));
		// 3. 將 score 新元素添加到 newScores
		newScores[newScores.length - 1] = score;
		System.out.println("newScores:" + Arrays.toString(newScores));
		// 4. 原 scores 變數 指向新的 newScores
		scores = newScores;
		System.out.println("scores:" + Arrays.toString(scores));
	}

}
