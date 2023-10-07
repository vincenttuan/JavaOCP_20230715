package day21;

public class Job {
	
	// 迴圈跑 1000 次
	public void work() {
		// 得到執行緒名稱
		String tName = Thread.currentThread().getName();
		for(int i=1;i<=1000;i++) {
			System.out.printf("%s -> %d\n", tName, i);
		}
	}
	
}
