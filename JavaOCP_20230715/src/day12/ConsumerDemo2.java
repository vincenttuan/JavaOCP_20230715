package day12;

import java.util.Arrays;
import java.util.function.Consumer;

public class ConsumerDemo2 {

	public static void main(String[] args) {
		String[] names = {"Alice", "Bob", "Clarlie"};
		Arrays.stream(names)
			  .forEach(t -> System.out.println(t));
		
		Consumer<String> consumer = t -> System.out.println(t);
		Consumer<String> consumer2 = t -> System.out.println("Hello " + t);
		Arrays.stream(names)
			  .forEach(consumer2);
		
	}

}
