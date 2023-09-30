package day20;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateSales {
	public static void main(String[] args) throws Exception {
		// 修改一筆 Sales 紀錄
		String sql = "update sales set date=?, product_id=?, qty=?, branch_id=? where id = ?";
		String today = "2023/9/29"; 
		int productId = 3;
		int qty = 23;
		int branchId = 4;
		int id = 75;
		
		try(Connection conn = SQLUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);) {
			
			pstmt.setString(1, today);
			pstmt.setInt(2, productId);
			pstmt.setInt(3, qty);
			pstmt.setInt(4, branchId);
			pstmt.setInt(5, id);
			
			int rowcount = pstmt.executeUpdate();
			
			System.out.println("修改異動筆數:" + rowcount);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
