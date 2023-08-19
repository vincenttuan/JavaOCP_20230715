package day07;

public class Employee {
	
	private int salary;
	protected String dept; // 部門
	
	public Employee() {
		System.out.println("E1");
	}
	
	public Employee(int salary) {
		System.out.println("E2");
		setSalary(salary);
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public void job() {
		System.out.println("做基層工作");
	}
	
}
