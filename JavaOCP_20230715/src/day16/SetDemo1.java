package day16;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo1 {

	public static void main(String[] args) {
		//Set set = new HashSet();       // [80, 100, 90]
		Set set = new LinkedHashSet();   // [100, 90, 80]
		//Set set = new TreeSet();       // [80, 90, 100]
		set.add(100); // int -> Integer
		set.add(90);  // int -> Integer
		set.add(Integer.valueOf(80)); // Integer
		System.out.println(set);
		System.out.println(set.size());
		// 取得每一個元素
		Iterator iter = set.iterator(); // 取得集合的尋訪器
		while (iter.hasNext()) {
			Object data = iter.next();
			System.out.println(data);
		}
		
		for(Object data : set) {
			System.out.println(data);
		}
		
		set.stream()
		   //.forEach(data -> System.out.println(data));
		   .forEach(System.out::println);
	}

}
