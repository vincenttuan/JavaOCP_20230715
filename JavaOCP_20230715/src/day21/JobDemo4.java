package day21;

public class JobDemo4 {

	public static void main(String[] args) {
		// 多執行緒運作
		JobA jobA = new JobA(); // Runnable 物件
		JobB jobB = new JobB(); // Runnable 物件
		// 建立二條執行緒分別存放 jobA 與 jobB
		Thread t1 = new Thread(jobA, "T1-A");
		Thread t2 = new Thread(jobB, "T2-B");
		
		t1.start();
		t2.start();
		
	}

}
