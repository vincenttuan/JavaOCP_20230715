package day01;

public class Student { // 學生
	String name; // 姓名
	int score;   // 成績
	
	boolean isPass() { // 判斷是否及格
		boolean pass = score > 60; // 判斷成績是否大於 60
		return pass; // 將結果回傳
	}
	
	void printResult() { // 印出結果
		System.out.printf("姓名:%s 分數:%d %s\n", name, score, (isPass()?"及格":"不及格 還差 " + (60-score) + " 分"));
	}
}
