package day01;

/*
 * 這是一個可以運算 BMI 的程式
 * 並根據性別不同得到不同的診斷結果
 * 男性: 18 <= bmi < 23
 * 女性: 17 <= bmi < 22
 * */
public class Person {
	String name;   // 姓名
	char sex;      // 性別('M', 'F')
	double height; // 身高
	double weight; // 體重
	
	double getBmi() { // 計算 bmi
		double bmi = weight / Math.pow(height/100, 2);
		return bmi;
	}
	
	
	void printResult() {
		System.out.printf("%c %s bmi值=%.2f\n", sex, name, getBmi());
	}
	
}
