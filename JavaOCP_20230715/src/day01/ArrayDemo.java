package day01;

public class ArrayDemo {

	public static void main(String[] args) {
		int x = 10;
		int y = 12;
		int z = 15;
		
		int[] array = {x, y, z}; // 將 3 個變數放到陣列中
		
		System.out.println(array.length); // 陣列長度
		System.out.println("--------");
		
		System.out.println(array[0]);
		System.out.println(array[1]);
		System.out.println(array[2]);
		System.out.println(array[0] + array[1] + array[2]);
		System.out.println("--------");
		
		// 使用 for-loop
		int sum = 0; // 總和
		for(int i=0;i<array.length;i++) {
			System.out.println(array[i]);
			sum += array[i]; // 總和累計 
		}
		System.out.println(sum);
		System.out.println("--------");
		
		// 使用 for-each(for-in)
		int sum2 = 0;
		for(int item : array) {
			System.out.println(item);
			sum2 += item;
		}
		System.out.println(sum2);
		
		
	}

}
