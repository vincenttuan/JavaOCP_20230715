package day20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadBranch {

	public static void main(String[] args) throws Exception {
		// 1. 註冊 MySQL(JDBC 4.0 以前)
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// 2. 連線資料設定
		String dbUrl = "jdbc:mysql://localhost:3306/demo?serverTimezone=Asia/Taipei";
		String username = "root";
		String password = "12345678";
		
		// 3. 建立 Connection(連線物件), Statement(SQL語法敘述物件), Result(資料結果集合)
		String sql = "select branch_id, city, branch_name from branch";
		
		try(Connection conn = DriverManager.getConnection(dbUrl, username, password);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);) {
			
			// 4. 將 rs 資料透過輪詢取出
			while (rs.next()) {
				int branchId = rs.getInt("branch_id");
				String city = rs.getString("city");
				String branchName = rs.getString("branch_name");
				
				System.out.printf("%d\t%s\t%s\n", branchId, city, branchName);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
