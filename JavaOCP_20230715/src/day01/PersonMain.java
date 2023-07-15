package day01;

public class PersonMain {

	public static void main(String[] args) {
		Person p1 = new Person();
		p1.name = "Jack";
		p1.sex = 'M';
		p1.height = 170.0;
		p1.weight = 60.0;
		
		Person p2 = new Person();
		p2.name = "Rose";
		p2.sex = 'F';
		p2.height = 165.0;
		p2.weight = 45.0;
		
		//System.out.println(p1.getBmi());
		//System.out.println(p2.getBmi());
		
		/*
		 * 期望能加上診斷結果(過輕, 正常或過重), 如下:
		 * M Jack bmi值=20.76 正常
		 * F Rose bmi值=16.53 過輕
		 * */
		p1.printResult();
		p2.printResult();
	}

}
