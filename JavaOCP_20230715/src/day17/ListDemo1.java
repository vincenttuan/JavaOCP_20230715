package day17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ListDemo1 {

	public static void main(String[] args) {
		//List<String> list = new ArrayList<>();
		List<String> list = new LinkedList<>();
		list.add("Java");
		list.add("Python");
		list.add("VB");
		list.add("C/C++");
		System.out.println(list);
		System.out.println(list.get(1));
		list.add(0, "Go");
		System.out.println(list);
		list.set(2, "C#"); // 變更 index = 2 的元素內容
		System.out.println(list);
		list.remove(2); // 移除 index = 2 的元素
		System.out.println(list);
		list.remove("VB"); // 移除指定元素(只會移除一個)
		System.out.println(list);
		boolean check = list.contains("Java"); // 所有集合元素中是否包含 "Java"
		System.out.println(check);
		
		list = new ArrayList<>(Arrays.asList("a", "ab", "abc", "abcd", "abcde"));
		System.out.println(list);
		// 要移除長度 >= 3 的元素
		list.removeIf(s -> s.length() >= 3); // Java 8 開始支援
		System.out.println(list);
		list.forEach(System.out::println); // Java 8 開始支援
		// 轉為靜態陣列 toArray
		//String[] array = list.toArray(String[]::new);
		String[] array = list.toArray(size -> new String[size]);
		System.out.println(Arrays.toString(array));
	}

}
