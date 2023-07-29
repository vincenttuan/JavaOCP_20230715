package day03;

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
		
		scheduler.scheduleAtFixedRate(() -> {}, 0, 1, TimeUnit.SECONDS);
		
		
	}
}
