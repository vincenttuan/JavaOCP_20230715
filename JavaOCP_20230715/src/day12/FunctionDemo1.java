package day12;

import java.util.function.Consumer;
import static java.lang.System.out;

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
		
		// Java 8 之後可以透過 Lambda 來簡化實作方法, 所以可以不用再透過一個類來實現介面
		Consumer<String> consumer2 = (String t) -> System.out.println("Hello2 " + t);
		consumer2.accept("Mary");
		
		Consumer<String> consumer3 = (String t) -> {
			System.out.print("Hello3 ");
			System.out.println(t);
		};
		consumer3.accept("Rose");
		
		Consumer<String> consumer4 = (t) -> System.out.println(t);
		consumer4.accept("Vincent");
		
		// 使用方法參考
		Consumer<String> consumer5 = System.out::println;
		consumer5.accept("Anita");
		
		// 使用方法參考 + import static
		Consumer<String> consumer6 = out::println;
		consumer6.accept("Joanna");
	}

}
