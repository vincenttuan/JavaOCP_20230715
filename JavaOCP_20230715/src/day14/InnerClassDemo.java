package day14;

class Outer { // 外部類別
	int x = 7; // Outer 的物件變數
	class Inner { // 內部類別(不可以有 static 成員)
		int x = 77;  // Inner 的物件變數
		void print() { // 物件方法
			int x = 777;  // 區域變數
			System.out.println("Hello 內部類別 !");
			System.out.println(x); // 777
			System.out.println(this.x); // 77
			System.out.println(Outer.this.x); // 7
		}
	}
	
	static class SInner { // 靜態內部類別
		static void display() { // 類別方法
			System.out.println("Hello 靜態內部類別 !");
		}
	}
	
	void foo() { // 方法
		int a = 100; // 區域變數(若該變數有給方法內部類別使用, 編譯時就會加入 final)
		//a = 101;
		class Demo { // 方法內部類別
			void show() {
				System.out.println("Hello 方法內部類別 !");
				System.out.println(a); // a 必須是 final 變數
			}
		}
		Demo demo = new Demo(); // 要自己 new
		demo.show();
	}
	
	
}

// 內部類別操作
public class InnerClassDemo {

	public static void main(String[] args) {
		Outer ou = new Outer();
		Outer.Inner in = ou.new Inner();
		in.print();
		//-------------------------------------
		Outer.SInner sin = new Outer.SInner();
		sin.display();
		//-------------------------------------
		ou.foo();
		
	}

}
