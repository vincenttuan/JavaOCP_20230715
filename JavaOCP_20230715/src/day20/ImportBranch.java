package day20;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ImportBranch {
	
	
	
	public static void main(String[] args) throws Exception  {
		Set<Map<String, String>> branches = getBranchSet();
		// 將 branches 的資料匯入到 mysql branch 資料表中
		
		
	}
	
	public static Set<Map<String, String>> getBranchSet() throws Exception {
		List<String> lines = Files.readAllLines(Paths.get("src/day18/sales_data.txt"));
		
		Set<Map<String, String>> branches = lines.stream()
				.skip(1) // 跳過首行
				.map(line -> line.split(","))
				.map(array -> {
					Map<String, String> map = new HashMap<>();
					map.put("city", array[4]);
					map.put("branch_name", array[5]);
					return map;
				})
				.collect(Collectors.toCollection(LinkedHashSet::new));
		return branches;
	}


}
