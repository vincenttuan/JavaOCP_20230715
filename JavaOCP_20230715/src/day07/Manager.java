package day07;

public class Manager extends Employee {
	
	public Manager() {
		//super(); // 可以不用寫
		System.out.println("M1");
	}
	
	public Manager(int salary) {
		super(salary);
		System.out.println("M2");
	}
	
	public void job() {
		System.out.println("做管理工作");
	}
}
