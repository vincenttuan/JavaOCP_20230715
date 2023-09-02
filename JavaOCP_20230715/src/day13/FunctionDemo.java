package day13;

import java.util.function.BiFunction;

/*
@FunctionalInterface
public interface Function<T,R> {
	R apply(T t);
}

@FunctionalInterface
public interface BiFunction<T,U,R> {
	R apply(T t, U u)
}

@FunctionalInterface
public interface BinaryOperator<T> extends BiFunction<T,T,T> {
	// T apply(T t1, T t2)
}

@FunctionalInterface
public interface UnaryOperator<T> extends Function<T,T> {
	// T apply(T t);
}
*/

public class FunctionDemo {

	public static void main(String[] args) {
		// size = S 打 8 折
		// size = M 打 7.5 折
		// size = L 打 5 折
		BiFunction<Character, Integer, Double> calcPrice = null; 
		calcPrice = (size, amount) -> size=='S'?amount*0.8:size=='M'?amount*0.75:amount*0.5;
		
		System.out.println(calcPrice.apply('S', 100));
		System.out.println(calcPrice.apply('M', 100));
		System.out.println(calcPrice.apply('L', 100));

	}

}
