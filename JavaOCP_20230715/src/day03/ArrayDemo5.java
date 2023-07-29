package day03;

import java.util.Arrays;

public class ArrayDemo5 {
	
	// 陣列資料過濾
	public static void main(String[] args) {
		// 有一陣列 arr: [1, 2, 3, 4, 5]
		int[] arr = {1, 2, 3, 4, 5};
		System.out.println("arr:" + Arrays.toString(arr));
		// 我希望將 arr 中的偶數拿掉使 arr: [1, 3, 5]
		// 步驟 1: 先計算出奇數有幾個
		int count = 0;
		for(int num : arr) {
			if(num % 2 != 0) {
				count++;
			}
		}
		System.out.println("有幾個奇數:" + count);
		
		// 步驟 2: 根據奇數的數量創造新的陣列 newArr
		int[] newArr = new int[count];
		System.out.println("newArray:" + Arrays.toString(newArr));
		
		// 步驟 3: 利用 for-loop 或 for-each 將 arr 中的奇數依序放入到新陣列 newArr
		int index = 0;
		for(int num : arr) {
			if(num % 2 != 0) {
				newArr[index] = num;
				index++;
			}
		}
		System.out.println("newArray:" + Arrays.toString(newArr));
		
		// 步驟 4: arr 指向新陣列 newArr
		arr = newArr;
		System.out.println("arr:" + Arrays.toString(arr));
		

	}

}
