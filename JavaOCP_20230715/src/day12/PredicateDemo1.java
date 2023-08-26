package day12;

import java.util.function.Predicate;

public class PredicateDemo1 {
	/*
	 * @FunctionalInterface
	 * public interface Predicate<T> {
	 *     boolean test(T t);
	 * }
	 * */
	public static void main(String[] args) {
		// 判斷分數是否及格 ?
		Predicate<Integer> predicate = score -> score >= 60;
		System.out.println(predicate.test(75));
		System.out.println(predicate.test(45));
		
		

	}

}
