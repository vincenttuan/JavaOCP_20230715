package day16;

import java.util.LinkedHashSet;
import java.util.Set;

public class SetDemo2 {

	public static void main(String[] args) {
		Set<Integer> set = new LinkedHashSet<>();
		set.add(100); // int -> Integer
		set.add(90); // int -> Integer
		set.add(80); // int -> Integer
		//set.add("國文"); // 編譯錯誤, 因為 "國文" 不是 Integer
		System.out.println(set);
		System.out.println(set.size());
		
		int sum = set.stream().mapToInt(Integer::intValue).sum();
		System.out.println(sum);

	}

}
