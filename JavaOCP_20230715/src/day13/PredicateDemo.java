package day13;

import java.util.function.BiPredicate;

/*
@FunctionalInterface
public interface Predicate<T> {
	boolean test(T t);
}

@FunctionalInterface
public interface BiPredicate<T,U> {
	boolean test(T t, U u)
}
*/

public class PredicateDemo {
	public static void main(String[] args) {
		BiPredicate<Integer, Double> pass = (score, weight) -> score*(1+weight) >= 60;
		System.out.println(pass.test(50, 0.2));
		System.out.println(pass.test(40, 0.2));
		
	}
}
