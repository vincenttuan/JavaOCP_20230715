package day22;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

// Runnable
class PrintJob implements Runnable {
	@Override
	public void run() {
		System.out.println("Hello Runnable");
	}
}

// Callable
class GetLotto implements Callable<Integer> {
	@Override
	public Integer call() throws Exception {
		int num = new Random().nextInt(100);
		return num;
	}
}

public class CallableDemo {
	public static void main(String[] args) {
		Thread t1 = new Thread(new PrintJob());
		t1.start();
		
		FutureTask<Integer> task = new FutureTask<Integer>(new GetLotto());
		Thread t2 = new Thread(task);
		t2.start();
		try {
			// 得到執行緒的回傳值
			Integer num = task.get();
			System.out.println(num);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
	}
}
