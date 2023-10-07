package day22;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

// Runnable
class PrintWork implements Runnable {
	@Override
	public void run() {
		System.out.println("Hello Runnable");
	}
}

// Callable
class GetNumber implements Callable<Integer> {
	@Override
	public Integer call() throws Exception {
		int num = new Random().nextInt(100);
		return num;
	}
}

public class CallableDemo2 {
	public static void main(String[] args) {
		// 使用 ExecutorService 來簡化執行緒使用程序
		
		
		
	}
}
