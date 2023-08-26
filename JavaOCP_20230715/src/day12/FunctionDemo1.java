package day12;

import java.util.function.Consumer;

public class FunctionDemo1 {
	/*
	 * @FunctionalInterface
	 * public interface Consumer<T> {
     *     void accept(T t);
	 * }
	 * 
	 * */
	public static void main(String[] args) {
		// 傳統是透過一個 ConsumerImpl 的類來實作 Consumer 介面 
		Consumer<String> consumer = new ConsumerImpl();
		consumer.accept("John");
		// Java 8 之後可以透過 Lambda 來簡化實作方法
		
		
	}

}
