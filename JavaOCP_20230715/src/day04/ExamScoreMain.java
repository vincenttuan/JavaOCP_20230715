package day04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;

public class ExamScoreMain {

	public static void main(String[] args) throws IOException {
		// 將 exam.txt 的內容取出並放到 List<String> 動態陣列中
		Path path = Paths.get("src/day04/exam.txt");
		List<String> list = Files.readAllLines(path);
		System.out.println(list);
		
		// 建立一個 List<ExamScore> 動態陣列
		List<ExamScore> examScores = new ArrayList<>();
		for(int i=2;i<list.size();i++) {
			String[] arr = list.get(i).split(",");
			int score1 = Integer.parseInt(arr[0]);
			int score2 = Integer.parseInt(arr[1]);
			int score3 = Integer.parseInt(arr[2]);
			int score4 = Integer.parseInt(arr[3]);
			ExamScore examScore = new ExamScore(score1, score2, score3, score4);
			// 將 examScore 物件放到 examScores 動態陣列中
			examScores.add(examScore);
		}
		
		// 計算資料筆數
		System.out.printf("資料筆數: %d\n", examScores.size());
		// 我要計算第一題的總分與平均
		int sum1 = examScores.stream()
							 .mapToInt(examScore -> examScore.getScore1())
							 .sum();
		int avg1 = sum1 / examScores.size();
		System.out.printf("第一題總分 %d 平均 %d\n", sum1, avg1);
		
		IntSummaryStatistics stat1 = examScores.stream()
				 							   .mapToInt(examScore -> examScore.getScore1())
				 							   .summaryStatistics();
		System.out.println(stat1);
		System.out.printf("第一題總分 %d 平均 %.1f\n", stat1.getSum(), stat1.getAverage());
		
		// 我要計算第二題的總分與平均
		int sum2 = examScores.stream()
				 .mapToInt(examScore -> examScore.getScore2())
				 .sum();
		int avg2 = sum2 / examScores.size();
		System.out.printf("第二題總分 %d 平均 %d\n", sum2, avg2);

	}

}
