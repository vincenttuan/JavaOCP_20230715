package day20;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadProduct {

	public static void main(String[] args) throws Exception {
		// 1. 註冊 MySQL(JDBC 4.0 以前)
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// 2. 連線資料設定
		String dbUrl = "jdbc:mysql://localhost:3306/demo?serverTimezone=Asia/Taipei";
		String username = "root";
		String password = "12345678";
		
		// 3. 建立 Connection(連線物件), Statement(SQL語法敘述物件), Result(資料結果集合)
		String sql = "select product_id, product_name, price from product order by product_id";
		
		try(Connection conn = DriverManager.getConnection(dbUrl, username, password);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);) {
			// 4. 將資料表欄位名稱取出
			ResultSetMetaData md = rs.getMetaData();
			for(int i=1;i<=md.getColumnCount();i++) {
				System.out.printf("%s\t", md.getColumnName(i));
			}
			System.out.println("\n---------------------------------------");
			// 5. 將 rs 資料內容透過輪詢取出
			while (rs.next()) {
				int productId = rs.getInt("product_id");
				String productName = rs.getString("product_name");
				BigDecimal price = rs.getBigDecimal("price");
				
				System.out.printf("%d\t%s\t%s\n", productId, productName, price);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
