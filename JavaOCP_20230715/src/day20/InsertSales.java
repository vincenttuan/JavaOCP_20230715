package day20;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertSales {
	public static void main(String[] args) throws Exception {
		// 新增一筆 Sales 紀錄
		String sql = "insert into sales(date, product_id, qty, branch_id) values(?, ?, ?, ?)";
		String today = "2023/9/30"; 
		int productId = 2;
		int qty = 15;
		int branchId = 2;
		
		try(Connection conn = SQLUtil.getConnection();
			// 加入 Statement.RETURN_GENERATED_KEYS 可以得到最新 id 值	
			PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
			
			pstmt.setString(1, today);
			pstmt.setInt(2, productId);
			pstmt.setInt(3, qty);
			pstmt.setInt(4, branchId);
			
			int rowcount = pstmt.executeUpdate();
			
			System.out.println("新增異動筆數:" + rowcount);
			
			// 得到最新 id
			ResultSet generatedKeys = pstmt.getGeneratedKeys();
			if(generatedKeys.next()) {
				int id = generatedKeys.getInt(1);
				System.out.println("新增成功, 新增的 id = " + id);
			} else {
				System.out.println("新增成功, 但無法取得 id");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
