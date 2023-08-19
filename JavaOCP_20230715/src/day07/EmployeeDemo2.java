package day07;

public class EmployeeDemo2 {

	public static void main(String[] args) {
		// 繼承下的建構子調用
		Manager mgr = new Manager();
		
		Manager mgr2 = new Manager(60000);
	}

}
