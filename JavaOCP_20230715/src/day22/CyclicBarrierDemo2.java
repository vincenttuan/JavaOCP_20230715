package day22;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// 利用 CyclicBarrier 來計算大數據的資料並匯入統一報表
// 有一個大數據 100, 30, 80 ...
//一條執行緒負責計算: 平均業績
//一條執行緒負責計算: 最高業績
//一條執行緒負責計算: 最低業績
//一條執行緒負責計算: 業績總和
// 本月報表: 平均業績=?, 最高業績=?, 最低業績=?, 業績總和=?
class DataCenter {
	public static final int[] data = {100, 30, 80}; // 大數據
	public static final Map<String, Integer> report = new LinkedHashMap<>(); // 報表
}

// 平均業績執行緒
class AvgThread extends Thread {
	private CyclicBarrier cb;
	AvgThread(CyclicBarrier cb) {
		this.cb = cb;
	}
	public void run() {
		double avg = Arrays.stream(DataCenter.data).average().getAsDouble();
		DataCenter.report.put("平均業績", (int)avg);
		try {
			cb.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
}

// 最高業績執行緒
class HightThread extends Thread {
	private CyclicBarrier cb;
	HightThread(CyclicBarrier cb) {
		this.cb = cb;
	}
	public void run() {
		int max = Arrays.stream(DataCenter.data).max().getAsInt();
		DataCenter.report.put("最高業績", max);
		try {
			cb.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
}

// 最低業績執行緒
class LowThread extends Thread {
	private CyclicBarrier cb;
	LowThread(CyclicBarrier cb) {
		this.cb = cb;
	}
	public void run() {
		int min = Arrays.stream(DataCenter.data).min().getAsInt();
		DataCenter.report.put("最低業績", min);
		try {
			cb.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
}

// 業績總和執行緒
class SumThread extends Thread {
	private CyclicBarrier cb;
	SumThread(CyclicBarrier cb) {
		this.cb = cb;
	}
	public void run() {
		int sum = Arrays.stream(DataCenter.data).sum();
		DataCenter.report.put("業績總和", sum);
		try {
			cb.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
}

public class CyclicBarrierDemo2 {
	public static void main(String[] args) {
		// 報表印出
		Runnable printReport = () -> System.out.println(DataCenter.report);
		
		// 請用 CyclicBarrier 來實現 !
		CyclicBarrier cb = new CyclicBarrier(4, printReport);
		
		ExecutorService executor = Executors.newFixedThreadPool(4);
		executor.submit(new AvgThread(cb));
		executor.submit(new HightThread(cb));
		executor.submit(new LowThread(cb));
		executor.submit(new SumThread(cb));
		
		executor.shutdown();
		
	}
}
