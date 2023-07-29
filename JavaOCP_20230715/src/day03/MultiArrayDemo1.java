package day03;

import java.util.Arrays;

public class MultiArrayDemo1 {

	public static void main(String[] args) {
		int[][] m = new int[2][3];
		m[0][0] = 10;
		m[0][1] = 20;
		m[0][2] = 30;
		m[1][0] = 40;
		m[1][1] = 50;
		m[1][2] = 60;
		// m[0] 是一個一維陣列
		System.out.println(Arrays.toString(m[0]));
		System.out.println(Arrays.toString(m[1]));
		// 利用 for-loop 將 m[0] + m[1] 的數字內容進行加總 = ?
		int sum = 0;
		for(int i=0;i<m.length;i++) {
			//System.out.println(m[i] + " -> " + Arrays.toString(m[i]));
			for(int k=0;k<m[i].length;k++) {
				//System.out.println(m[i][k]);
				sum += m[i][k];
			}
		}
		System.out.println(sum);
		
	}

}
