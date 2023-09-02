package day14;

class Outer { // 外部類別
	class Inner { // 內部類別
		void print() {
			System.out.println("Hello inner !");
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
