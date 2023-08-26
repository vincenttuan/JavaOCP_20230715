package day12;

import java.util.function.Consumer;

public class ConsumerImpl implements Consumer<String> {

	@Override
	public void accept(String t) {
		System.out.println("Hello " + t);
	}

}
