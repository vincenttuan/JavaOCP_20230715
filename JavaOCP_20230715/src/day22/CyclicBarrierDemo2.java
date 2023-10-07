package day22;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CyclicBarrier;

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
	}
}

public class CyclicBarrierDemo2 {

}
