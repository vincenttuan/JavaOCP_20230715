package day20;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLUtil {
	private static Connection conn = null;
	static {
		try {
			// 1. 註冊 MySQL(JDBC 4.0 以前)
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2. 連線資料設定
			String dbUrl = "jdbc:mysql://localhost:3306/demo?serverTimezone=Asia/Taipei";
			String username = "root";
			String password = "12345678";
			conn = DriverManager.getConnection(dbUrl, username, password);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static Connection getConnection() {
		return conn;
	}
}
