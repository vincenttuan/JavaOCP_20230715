package day21;

public class JobDemo {

	public static void main(String[] args) {
		// 單工運作
		Job job1 = new Job();
		Job job2 = new Job();
		job1.work(); // 單工模式調用
		job2.work(); // 單工模式調用
	}

}
