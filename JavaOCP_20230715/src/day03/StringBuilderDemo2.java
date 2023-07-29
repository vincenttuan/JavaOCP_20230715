package day03;

import java.time.LocalTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class StringBuilderDemo2 {
	public static void main(String[] args) {
		// 一般利用 while(ture) 會每隔一段時間重複執行的邏輯
		// 可以改成利用 ScheduledExecutorService 排程化可執行服務
		
		StringBuilder sb = new StringBuilder("00:00:00");
		
		// 建立一個排程化可執行服務與來取代 while(true) 的寫法
		ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
		
		scheduler.scheduleAtFixedRate(() -> {
			
			// 獲取當前時間
			LocalTime now = LocalTime.now();
			//System.out.println("now = " + now);
			
			// 將時分秒插入到 sb 的位置
			sb.replace(0, 2, String.format("%02d", now.getHour()));
			sb.replace(3, 5, String.format("%02d", now.getMinute()));
			sb.replace(6, 8, String.format("%02d", now.getSecond()));
			
			System.out.println(sb);
			
			// 當時間等於某一時間時就停止服務
			if(now.getHour() == 14 && now.getMinute() == 11 && now.getSecond() == 35) {
				scheduler.shutdown(); // 停止服務
			}
			
		}, 0, 1, TimeUnit.SECONDS);
		
		
	}
}
