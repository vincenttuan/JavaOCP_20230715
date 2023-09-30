package day19;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class 過濾出Branch資料 {

	public static void main(String[] args) throws Exception {
		List<String> lines = Files.readAllLines(Paths.get("src/day18/sales_data.txt"));
		
		// 利用 for-loop
		Set<Map<String, String>> branches = new LinkedHashSet<>();
		for(int i=1;i<lines.size();i++) {
			String[] array = lines.get(i).split(",");
			Map<String, String> map = new HashMap<>();
			map.put("city", array[4]);
			map.put("branch_name", array[5]);
			branches.add(map);
			//System.out.println(array[4] + " " + array[5]);
		}
		System.out.println(branches);
		
		// 利用 Java stream
		branches = lines.stream()
				.skip(1) // 跳過首行
				.map(line -> line.split(","))
				.map(array -> {
					Map<String, String> map = new HashMap<>();
					map.put("city", array[4]);
					map.put("branch_name", array[5]);
					return map;
				})
				.collect(Collectors.toCollection(LinkedHashSet::new));
		System.out.println(branches);
		
	}

}
