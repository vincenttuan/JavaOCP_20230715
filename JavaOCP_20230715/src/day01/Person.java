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
	
	String getBmiResult() { // 得到 bmi 診斷結果
		String result = "正常";
		double bmi = getBmi(); // 取得 bmi 值
		switch (sex) { // 根據性別來判斷
			case 'M':
				if(bmi <= 18) result = "過輕";
				else if(bmi > 23) result = "過重";
				break;
			case 'F':
				if(bmi <= 17) result = "過輕";
				else if(bmi > 22) result = "過重";
				break;	
		}
		return result;
	}
	
	void printResult() { // 印出結果
		System.out.printf("%c %s bmi值=%.2f %s\n", sex, name, getBmi(), getBmiResult());
	}
	
}
