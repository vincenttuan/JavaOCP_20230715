package day01;

public class Student { // 學生
	String name; // 姓名
	int score;   // 成績
	
	boolean isPass() {
		boolean pass = score > 60; // 判斷成績是否大於 60
		return pass; // 將結果回傳
	}
}
