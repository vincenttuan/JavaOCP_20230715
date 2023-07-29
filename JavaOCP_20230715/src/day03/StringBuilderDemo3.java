package day03;

public class StringBuilderDemo3 {

	public static void main(String[] args) {
		// 1. StringBuilder 在串接大量字串比 String 高校
		StringBuilder sb1 = new StringBuilder();
		for(int i=0;i<100;i++) {
			sb1.append(i).append(" ");
		}
		System.out.println(sb1);
		
		// 2. 可以插入,刪除和替換指定文字方便
		StringBuilder sb2 = new StringBuilder("Word"); // Word
		sb2.insert(0, "Hello,");  // Hello,Word
		System.out.println(sb2);
		//sb2.delete(5, 6); // HelloWord
		sb2.replace(5, 6, " "); // Hello Word
		System.out.println(sb2);
		
		// 3. 翻轉字串
		StringBuilder sb3 = new StringBuilder("ABCD");
		sb3.reverse();
		System.out.println(sb3);
		
	}

}
