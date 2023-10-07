package day21;

import java.util.Random;

// JobB 工作 
// 產生 0~9 的亂數
public class JobB implements Runnable {

	@Override
	public void run() {
		// 得到執行緒名稱
		String tName = Thread.currentThread().getName();
		// 產生 0~9 的亂數
		Random random = new Random();
		for(int i=1;i<=100;i++) {
			int num = random.nextInt(10);
			System.out.printf("%02d JobB %s -> %d\n", i, tName, num);
		}
	}
	
}
