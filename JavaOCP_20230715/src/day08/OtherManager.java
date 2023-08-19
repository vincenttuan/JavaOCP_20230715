package day08;

import day07.Employee;

public class OtherManager {
	
	public void setDept() {
		Employee emp = new Employee();
		// 在不同 package 的情況下
		// 因為 OtherManager 沒有繼承 Employee 
		// 所以無法使用 Manager 中所定義的 protected 資源
		//emp.dept = "銷售部"; 
	}
	
}
