package day20;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ImportSales {
	
	public static void main(String[] args) throws Exception  {
		Set<Map<String, String>> sales = getSalesSet();
		
		// 將 sales 的資料匯入到 mysql sales 資料表中
		String sql = "insert into sales(date, product_id, qty, branch_id) values(?, ?, ?, ?, ?)";
		/*
		try(Connection conn = SQLUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);) {
			// 批次新增
			pstmt.clearBatch(); // 清除批次暫存
			for(Map<String, String> map : branches) {
				pstmt.setString(1, map.get("city"));
				pstmt.setString(2, map.get("branch_name"));
				pstmt.addBatch(); // 加入到批次
			}
			// 執行批次
			int[] rowscount = pstmt.executeBatch();
			System.out.println("每一筆的執行回傳效果:" + Arrays.toString(rowscount));
			System.out.println("共新增筆數:" + Arrays.stream(rowscount).sum());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		*/
	}
	
	public static Set<Map<String, String>> getSalesSet() throws Exception {
		List<String> lines = Files.readAllLines(Paths.get("src/day18/sales_data.txt"));
		
		Set<Map<String, String>> branches = lines.stream()
				.skip(1) // 跳過首行
				.map(line -> line.split(","))
				.map(array -> {
					Map<String, String> map = new HashMap<>();
					map.put("date", array[0]);
					map.put("product_name", array[1]);
					map.put("price", array[2]);
					map.put("qty", array[3]);
					map.put("city", array[4]);
					map.put("branch_name", array[5]);
					return map;
				})
				.collect(Collectors.toCollection(LinkedHashSet::new));
		return branches;
	}


}
