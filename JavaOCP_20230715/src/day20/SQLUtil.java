package day20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import day20.po.Branch;
import day20.po.Product;

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
	
	// 取得所有 branches
	public static List<Branch> queryBranches() {
		List<Branch> branches = new ArrayList<>();
		String sql = "select branch_id, city, branch_name from branch order by branch_id";
		try(Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql)) {
			
			while (rs.next()) {
				Branch branch = new Branch();
				branch.setBranchId(rs.getInt("branch_id"));
				branch.setCity(rs.getString("city"));
				branch.setBranchName(rs.getString("branch_name"));
				branches.add(branch);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return branches;
	}
	
	// 取得所有 products
	public static List<Product> queryProducts() {
		List<Product> products = new ArrayList<>();
		String sql = "select product_id, product_name, price from product order by product_id";
		try(Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql)) {
			
			while (rs.next()) {
				Product product = new Product();
				product.setProductId(rs.getInt("product_id"));
				product.setProductName(rs.getString("product_name"));
				product.setPrice(rs.getBigDecimal("price"));
				products.add(product);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return products;
	}
	
}
