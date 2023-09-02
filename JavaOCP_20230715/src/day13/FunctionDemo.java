package day13;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

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
		
		//BiFunction<Double, Double, Double> calcBmi = (h, w) -> w / Math.pow(h/100, 2);
		BinaryOperator<Double> calcBmi = (h, w) -> w / Math.pow(h/100, 2);
		System.out.println(calcBmi.apply(170.0, 60.0));
		
		//Function<Double, Double> calcArea = (r) -> Math.pow(r, 2) * Math.PI;
		UnaryOperator<Double> calcArea = (r) -> Math.pow(r, 2) * Math.PI;
		System.out.println(calcArea.apply(10.5));
	}

}











