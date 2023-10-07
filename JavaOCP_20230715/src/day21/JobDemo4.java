package day21;

public class JobDemo4 {

	public static void main(String[] args) {
		// 多執行緒運作
		JobA jobA = new JobA(); // Runnable 物件
		JobB jobB = new JobB(); // Runnable 物件
		// 建立二條執行緒分別存放 jobA 與 jobB
		Thread t1 = new Thread(jobA, "T1-A");
		Thread t2 = new Thread(jobB, "T2-B");
		// 設定權限 1(小)~10(大)
		// 權限越大越容易被排程選到多次
		t2.setPriority(Thread.MAX_PRIORITY); // t2.setPriority(10); // 1~10
		t1.setPriority(Thread.MIN_PRIORITY); // t1.setPriority(1); // 1~10
		// 啟動
		t1.start();
		t2.start();
		
	}

}
