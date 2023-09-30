package day20;

import java.math.BigDecimal;
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

public class ImportProduct {
	
	public static void main(String[] args) throws Exception  {
		Set<Map<String, String>> products = getProductSet();
		// 將 products 的資料匯入到 mysql product 資料表中
		String sql = "insert into product(product_name, price) values(?, ?)";
		try(Connection conn = SQLUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);) {
			// 批次新增
			pstmt.clearBatch(); // 清除批次暫存
			for(Map<String, String> map : products) {
				pstmt.setString(1, map.get("product_name"));
				pstmt.setBigDecimal(2, new BigDecimal(map.get("price")));
				pstmt.addBatch(); // 加入到批次
			}
			// 執行批次
			int[] rowscount = pstmt.executeBatch();
			System.out.println("每一筆的執行回傳效果:" + Arrays.toString(rowscount));
			System.out.println("共新增筆數:" + Arrays.stream(rowscount).sum());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static Set<Map<String, String>> getProductSet() throws Exception {
		List<String> lines = Files.readAllLines(Paths.get("src/day18/sales_data.txt"));
		
		Set<Map<String, String>> branches = lines.stream()
				.skip(1) // 跳過首行
				.map(line -> line.split(","))
				.map(array -> {
					Map<String, String> map = new HashMap<>();
					map.put("product_name", array[1]);
					map.put("price", array[2]);
					return map;
				})
				.collect(Collectors.toCollection(LinkedHashSet::new));
		return branches;
	}


}
