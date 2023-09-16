package day17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 可變集合/不可變集合/不可修改集合
 
            +-----+-----+--------+
            | add | set | remove |
 +----------+-----+-----+--------+
 | 可以變的集合 |  V  |  V  |   V    | new ArrayList(), new LinkedList()...
 +----------+-----+-----+--------+
 | 不可變的集合 |  X  |  V  |   X    | Arrays.asList(...)
 +----------+-----+-----+--------+
 | 不可修改集合 |  X  |  X  |   X    | Collections.unmodifiableList(...), List.of(...) ...
 +----------+-----+-----+--------+
  
 */
public class ListDemo2 {
	public static void main(String[] args) {
		// 可變集合
		List<Integer> list = new ArrayList<>();
		System.out.println(list);
		list.add(100);
		list.add(90);
		System.out.println(list);
		list.add(80);
		System.out.println(list);
		
		//不可變集合(元素長度不可變)
		List<Integer> list2 = Arrays.asList(100);
		System.out.println(list2);
		//list2.add(90); // 不可新增
		list2.set(0, 90); // 可以修改
		System.out.println(list2);
		//list2.remove(0); // 不可刪除
		
		// 不可變集合變成可變集合
		List<Integer> list3 = new ArrayList<>(list2);
		
		// 不可修改集合
		List<Integer> list4 = Collections.unmodifiableList(Arrays.asList(100));
		System.out.println(list4); // [100]
		//list4.add(90); // 不可新增
		//list4.set(0, 90); // 不可以修改, 會錯誤
		//list4.remove(0); // 不可刪除
		
		// Java 9
		List<Integer> list5 = List.of(100, 90, 80);
		System.out.println(list5);
		//list5.set(0, 70); // 不可以修改, 會錯誤
		
	}
}
