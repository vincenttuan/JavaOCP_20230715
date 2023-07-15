package day01;

public class StudentMain {

	public static void main(String[] args) {
		Student s1 = new Student();
		s1.name = "John"; // 設定姓名
		s1.score = 70;    // 設定分數
		
		Student s2 = new Student();
		s2.name = "Mary"; // 設定姓名
		s2.score = 55;    // 設定分數
		
		System.out.println(s1.isPass());
		System.out.println(s2.isPass());
	}

}
