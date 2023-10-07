package day21;

public class JobDemo2 {

	public static void main(String[] args) {
		// 多執行緒運作
		Job job1 = new Job();
		Job job2 = new Job();
		//job1.work(); // 單工模式調用
		//job2.work(); // 單工模式調用
		// job1 與 job2稱為 User 執行緒 (使用者/前端執行緒)
		// main 主執行緒一定會等 User 執行緒都完成工作後才會結束程式
		job1.start();  // 多執行緒模式調用
		job2.start();  // 多執行緒模式調用
		System.out.println("執行緒數量: " + Thread.activeCount() + " -> " + Thread.currentThread().getName());
	}

}
