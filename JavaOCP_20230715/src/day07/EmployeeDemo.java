package day07;

public class EmployeeDemo {

	public static void main(String[] args) {
		// 建立員工
		Employee emp = new Employee();
		emp.setSalary(40000);
		System.out.printf("員工薪資: $%d\n", emp.getSalary());
		System.out.print("員工工作: ");
		emp.job();
		
		// 建立經理
		Manager mgr = new Manager();
		mgr.setSalary(75000);
		System.out.printf("經理薪資: $%d\n", mgr.getSalary());
		System.out.print("經理工作: ");
		mgr.job();
		
	}

}
