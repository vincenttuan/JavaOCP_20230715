package day04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
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
		

	}

}
