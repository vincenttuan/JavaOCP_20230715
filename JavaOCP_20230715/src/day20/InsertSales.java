package day20;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertSales {
	public static void main(String[] args) throws Exception {
		// 新增一筆 Sales 紀錄
		String sql = "insert into sales(date, product_id, qty, branch_id) values(?, ?, ?, ?)";
		String today = "2023/9/30"; 
		int productId = 2;
		int qty = 15;
		int branchId = 2;
		
		try(Connection conn = SQLUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);) {
			
			pstmt.setString(1, today);
			pstmt.setInt(2, productId);
			pstmt.setInt(3, qty);
			pstmt.setInt(4, branchId);
			
			int rowcount = pstmt.executeUpdate();
			System.out.println("新增異動筆數:" + rowcount);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
