package day03;

import java.sql.Time;
import java.time.LocalTime;

public class StringBuilderDemo1 {

	public static void main(String[] args) throws InterruptedException {
		
		StringBuilder sb = new StringBuilder("00:00:00");
		System.out.println(sb);
		// 將現在時間 HH:mm:ss 放到 sb 的指定位置
		while(true) {
			// 獲取當前時間
			LocalTime now = LocalTime.now();
			//System.out.println("now = " + now);
			
			// 將時分秒插入到 sb 的位置
			sb.replace(0, 2, String.format("%02d", now.getHour()));
			sb.replace(3, 5, String.format("%02d", now.getMinute()));
			sb.replace(6, 8, String.format("%02d", now.getSecond()));
			
			System.out.println(sb);
			
			Thread.sleep(1000); // 停 1000ms = 1s
		}
		
	}

}
