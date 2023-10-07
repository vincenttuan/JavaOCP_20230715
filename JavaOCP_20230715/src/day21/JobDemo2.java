package day21;

public class JobDemo2 {

	public static void main(String[] args) {
		// 多執行緒運作
		Job job1 = new Job();
		Job job2 = new Job();
		//job1.work(); // 單工模式調用
		//job2.work(); // 單工模式調用
		job1.start();  // 多執行緒模式調用
		job2.start();  // 多執行緒模式調用
	}

}
