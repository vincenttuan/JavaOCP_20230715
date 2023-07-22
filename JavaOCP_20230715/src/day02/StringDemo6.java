package day02;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import com.google.gson.Gson;

public class StringDemo6 {

	public static void main(String[] args) throws IOException {
		// 請計算出 "學生成績檔C.txt" 所有分數的總和
		File file = new File("src/day02/學生成績檔C.txt");
		String jsonString = new Scanner(file).useDelimiter("\\A").next();
		System.out.printf("json 字數: %d\n", jsonString.length());
		
		Gson gson = new Gson();
		Student[] students = gson.fromJson(jsonString, Student[].class);
		
		System.out.println(Arrays.toString(students));
		
		int summary = 0;
		for(Student student : students) {
			summary += Integer.parseInt(student.SCORE1);
			summary += Integer.parseInt(student.SCORE2);
			summary += Integer.parseInt(student.SCORE3);
		}
		System.out.printf("成績總和: %,d\n", summary);
		
		// 假設 SCORE1, SCORE2, SCORE3 是該名學生的三次考試成績
		// 請印出成績是逐漸進步的學生名字
		System.out.println("成績是逐漸進步的學生名字:");
		for(Student student : students) {
			if(student.isImproving()) {
				System.out.printf("%s 成績:%s %s %s\n", student.NAME, student.SCORE1, student.SCORE2, student.SCORE3);
			}
		}
		
		System.out.println("成績是逐漸退步的學生名字:");
		for(Student student : students) {
			if(student.isDeclining()) {
				System.out.printf("%s 成績:%s %s %s\n", student.NAME, student.SCORE1, student.SCORE2, student.SCORE3);
			}
		}
		
	}

}
