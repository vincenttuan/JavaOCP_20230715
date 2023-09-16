package day18;

import java.util.LinkedHashMap;
import java.util.Map;

public class MapDemo1 {

	public static void main(String[] args) {
		Map<String, Integer> map = new LinkedHashMap<>();
		map.put("國文", 100);
		map.put("數學", 90);
		map.put("英文", 80);
		System.out.println(map);
		System.out.println(map.keySet());
		System.out.println(map.values());
		
		// Map 中一組(Key/Value)的資料集/元素 稱為 Entry
		// 很多的 Entry 稱為 EntrySet
		for(Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(entry);
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
		
		System.out.println("-------------------------------");
		System.out.println(map.get("國文")); // 100
		System.out.println(map.get("美術")); // null
		System.out.println(map.getOrDefault("美術", 0)); // 若無此元素會得到 0
		System.out.println(map);
		
		System.out.println("-------------------------------");
		// putIfAbsent() 若該元素不存在才加入
		System.out.println(map.putIfAbsent("國文", 90));
		System.out.println(map);
		System.out.println(map.putIfAbsent("自然", 45));
		System.out.println(map);
		
		// 若指定元素的值不及格就變為及格
		map.compute("自然", (key, value) -> value < 60 ? 60 : value);
		System.out.println(map);
		
		// 若"社會"存在才要修改元素內容
		map.computeIfPresent("社會", (key, value) -> value < 60 ? 60 : value);
		System.out.println(map);
		
		// 若"社會"不存在就新增元素並給定60分
		map.computeIfAbsent("社會", (value) -> 60);
		System.out.println(map);
		
		
	}

}
