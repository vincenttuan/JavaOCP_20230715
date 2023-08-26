package day11;

import java.util.Random;

public interface Car {
	// 抽象方法(待實作的方法)
	void start(); // public abstract void start();
	void stop();  // public abstract void stop();
	
	// Java 8 之後在 interface 可以透過 default 關鍵字提供有實作的 public 方法
	default void copyright() {  // public default void copyright() 
		System.out.println("版權所有");
	}
}
 
