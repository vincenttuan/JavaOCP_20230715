package day12;

import java.util.Arrays;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class PredicateDemo1 {
	/*
	 * @FunctionalInterface
	 * public interface Predicate<T> {
	 *     boolean test(T t);
	 * }
	 * 
	 * @FunctionalInterface
	 * public interface IntPredicate {
     *     boolean test(int value);
	 * }
	 * */
	public static void main(String[] args) {
		// 判斷分數是否及格 ?
		Predicate<Integer> predicate = score -> score >= 60;
		System.out.println(predicate.test(75));
		System.out.println(predicate.test(45));
		
		// 印出及格的分數
		int[] scores = {100, 40, 50, 70, 80};
		IntPredicate pass = score -> score >= 60;
		Arrays.stream(scores)
			  //.filter(score -> score >= 60)
			  .filter(pass)
			  .forEach(System.out::println);
		
		// 印出及格分數
		String[] scoreArray = {"100", "一百", "40", "80", null, "70"};
		
		
	}

}











