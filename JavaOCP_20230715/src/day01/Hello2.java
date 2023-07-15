package day01;

public class Hello2 {

	public static void main(String[] args) {
		if(args.length >=2) {
			System.out.print("收到第一個參數:");
			System.out.println(args[0]);
		
			System.out.print("收到第二個參數:");
			System.out.println(args[1]);
		} else {
			System.out.println("請在執行時輸入二個參數");
		}
	}

}
