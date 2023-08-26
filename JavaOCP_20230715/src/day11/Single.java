package day11;

@FunctionalInterface
// Java 8 引入的一個標注-FunctionalInterface(功能性標注)
// 功能性介面是只有一個抽象方法, 但是可以有很多 default 或 static 關鍵字所定義的非抽象方法
// interface 中 static 與 default 存在的目的
// static: 使屬於類別資源, 不依賴特定實例的功能
// default(預設實作): 允許開發者在不破壞現有的實作情況下, 向介面加添新方法
public interface Single {
	// 抽象方法-無實作
	int calc(int x, int y);
	// 類別方法-有實作
	static void foo() {
		System.out.println("foo");
	}
	// 預設方法-有實作
	default void bar() {
		selfMethod();
		System.out.println("bar");
	}
	// 私有方法-有實作
	// Java 9 開始可以在介面中使用 private 有帶實作的方法
	// 目的是給 default 方法之間可以進行代碼重用的需求
	private void selfMethod() {
		System.out.println("self");
	}
}
