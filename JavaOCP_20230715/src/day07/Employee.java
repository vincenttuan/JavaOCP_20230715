package day07;

public class Employee {
	
	private int salary;
	
	public Employee() {
		
	}
	
	public Employee(int salary) {
		this.salary = salary;
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
