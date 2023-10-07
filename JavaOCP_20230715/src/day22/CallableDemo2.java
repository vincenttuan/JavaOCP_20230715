package day22;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
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
	public static void main(String[] args) throws Exception {
		// 使用 ExecutorService 來簡化執行緒使用程序
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		// 提交並執行 PrintWork
		//executor.execute(new PrintWork());
		Future fut = executor.submit(new PrintWork());
		System.out.println(fut.get()); // 得到 null, 因為無回傳值
		
		// 提交並執行 GetNumber
		Future<Integer> future = executor.submit(new GetNumber());
		Integer num = future.get();
		System.out.println(num);
		
		// 關閉 service
		executor.shutdown();
		
	}
}
