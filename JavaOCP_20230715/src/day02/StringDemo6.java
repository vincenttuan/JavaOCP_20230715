package day02;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.math3.stat.correlation.PearsonsCorrelation;

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
		
		// SCORE1, SCORE2, SCORE3 相關分析
		List<Double> score1s = new ArrayList<>();
        List<Double> score2s = new ArrayList<>();
        List<Double> score3s = new ArrayList<>();

        for (Student student : students) {
            score1s.add(Double.parseDouble(student.SCORE1));
            score2s.add(Double.parseDouble(student.SCORE2));
            score3s.add(Double.parseDouble(student.SCORE3));
        }

        double[] score1Array = score1s.stream().mapToDouble(d->d).toArray();
        double[] score2Array = score2s.stream().mapToDouble(d->d).toArray();
        double[] score3Array = score3s.stream().mapToDouble(d->d).toArray();

        PearsonsCorrelation pc = new PearsonsCorrelation();
        // correlation 相關係數
        // 0.3: 弱相關, 0.45: 中度相關, 0.7: 高度相關
        System.out.println("SCORE1 與 SCORE2 的相關性: " + pc.correlation(score1Array, score2Array));
        System.out.println("SCORE1 與 SCORE3 的相關性: " + pc.correlation(score1Array, score3Array));
        System.out.println("SCORE2 與 SCORE3 的相關性: " + pc.correlation(score2Array, score3Array));
	}

}
