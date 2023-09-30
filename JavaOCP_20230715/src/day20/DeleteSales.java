package day20;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteSales {
	public static void main(String[] args) throws Exception {
		// 刪除一筆 Sales 紀錄
		String sql = "delete from sales where id = ?";
		int id = 75;
		
		try(Connection conn = SQLUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);) {
			
			pstmt.setInt(1, id);
			
			int rowcount = pstmt.executeUpdate();
			
			System.out.println("刪除異動筆數:" + rowcount);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
