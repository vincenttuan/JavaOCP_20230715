package day11;

@FunctionalInterface
// Java 8 引入的一個標注-FunctionalInterface(功能性標注)
// 功能性介面是只有一個抽象方法, 但是可以有很多 default 或 static 關鍵字所定義的非抽象方法
// interface 中 static 與 default 存在的目的
// static: 使屬於類別資源, 不依賴特定實例的功能
// default(預設實作): 允許開發者在不破壞現有的實作情況下, 向介面加添新方法
public interface Single {
	int calc(int x, int y);
	static void foo() {
		System.out.println("foo");
	}
	default void bar() {
		System.out.println("bar");
	}
}