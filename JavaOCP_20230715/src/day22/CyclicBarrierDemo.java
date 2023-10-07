package day22;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;

class Car extends Thread {
	private CyclicBarrier cyclicBarrier;
	private String threadName;
	Car(CyclicBarrier cyclicBarrier) {
		this.cyclicBarrier = cyclicBarrier;
		this.threadName = Thread.currentThread().getName();
	}

	@Override
	public void run() {
		System.out.printf("%s 台北出發\n", threadName);
		try {
			// 模擬執行時間
			Thread.sleep(new Random().nextInt(5000));
			// 到台中
			System.out.printf("%s 到台中\n", threadName);
			// 等待其他人
			cyclicBarrier.await();
		} catch (Exception e) {
			
		}
		// 繼續往高雄出發
		System.out.printf("%s 到高雄\n", threadName);
	}
	
}

public class CyclicBarrierDemo {

	public static void main(String[] args) {
		

	}

}
