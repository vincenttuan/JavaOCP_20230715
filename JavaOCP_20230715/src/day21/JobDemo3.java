package day21;

public class JobDemo3 {

	public static void main(String[] args) {
		// 多執行緒運作
		Job job1 = new Job();
		Job job2 = new Job();
		// job1 為 User 執行緒 (使用者/前端執行緒)
		// job2 為 Daemon 執行緒 (背景執行緒)
		job2.setDaemon(true);
		// main 主執行緒一定會等 User 執行緒都完成工作後才會結束程式
		// main 主執行緒並不會等待 Daemon 執行緒都完成工作後才結束程式
		job1.start();  // 多執行緒模式調用
		job2.start();  // 多執行緒模式調用
		System.out.println("執行緒數量: " + Thread.activeCount() + " -> " + Thread.currentThread().getName());
	}

}
