package day21;

import java.util.Random;

// JobA 工作 
// 產生 000~999 的亂數
public class JobA implements Runnable {

	@Override
	public void run() {
		// 得到執行緒名稱
		String tName = Thread.currentThread().getName();
		// 產生 000~999 的亂數
		Random random = new Random();
		for(int i=1;i<=100;i++) {
			int num = random.nextInt(1000);
			System.out.printf("%d JobA %s -> %03d\n", i, tName, num);
		}
	}
	
}
