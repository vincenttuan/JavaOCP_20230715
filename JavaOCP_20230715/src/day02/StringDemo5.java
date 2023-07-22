package day02;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class StringDemo5 {

	public static void main(String[] args) throws IOException {
		// 請計算出 "學生成績檔A.txt" 所有分數的總和
		File file = new File("src/day02/學生成績檔A.txt");
		String allData = new Scanner(file).useDelimiter("\\A").next();
		System.out.printf("字數: %d\n", allData.length());
		String[] rows = allData.split(System.lineSeparator());
		System.out.printf("筆數: %d\n", rows.length);
		System.out.println(Arrays.toString(rows));
		
		Student[] students = new Student[rows.length];
		for(int i=0;i<rows.length;i++) {
			String data = rows[i];
			
			String[] dataArray = data.split(",");
			final String NAME = dataArray[0];
			final String SCORE1 = dataArray[1];
			final String SCORE2 = dataArray[2];
			final String SCORE3 = dataArray[3];
			
			Student student = new Student(NAME, SCORE1, SCORE2, SCORE3);
			students[i] = student;
		}
		
		System.out.println(Arrays.toString(students));
		
		int summary = 0;
		for(Student student : students) {
			summary += Integer.parseInt(student.SCORE1);
			summary += Integer.parseInt(student.SCORE2);
			summary += Integer.parseInt(student.SCORE3);
		}
		System.out.printf("成績總和: %,d\n", summary);
		
	}

}
