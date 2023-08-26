package day12;

import java.util.function.Consumer;

public class FunctionDemo1 {
	/*
	 * @FunctionalInterface
	 * 	public interface Consumer<T> {
     * 		void accept(T t);
	 * }
	 * 
	 * */
	public static void main(String[] args) {
		Consumer<String> consumer = new ConsumerImpl();
		consumer.accept("John");

	}

}
