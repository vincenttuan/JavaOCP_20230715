package day14;

class Outer { // 外部類別
	int x = 7; // Outer 的物件變數
	class Inner { // 內部類別
		int x = 77;  // Inner 的物件變數
		void print() {
			int x = 777;  // 區域變數
			System.out.println("Hello inner !");
			System.out.println(x); // 777
			System.out.println(this.x); // 77
			System.out.println(Outer.this.x); // 7
		}
	}
	
	void foo() { // 方法
		class Demo { // 方法內部類別
			
		}
	}
	
	static class SInner { // 靜態內部類別
		
	}
}

// 內部類別操作
public class InnerClassDemo {

	public static void main(String[] args) {
		Outer ou = new Outer();
		Outer.Inner in = ou.new Inner();
		in.print();
	}

}
