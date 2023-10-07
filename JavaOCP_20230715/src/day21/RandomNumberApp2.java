package day21;

import java.awt.Font;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 
 +-------+
 |  999  | 
 +-------+
 
 1. 有二條執行緒分別產出 0~9, 000~999 的亂數
 2. 產生後的資料不是直接更新 UI 而是先放到 Queue 中
 3. 再由一條執行緒去偵測 Queue 中有無資料, 若有就取出資料並更新 UI
 4. ExecutorService 來簡化執行緒的創與管理, 並具備有執行緒池的功能
 */

public class RandomNumberApp2 {
	private static final BlockingQueue<String> queue = new LinkedBlockingDeque<>();
	
	// 亂數產生器
	static class RandomNumberGenerator implements Runnable {
		private final Random random = new Random();
		@Override
		public void run() {
			// 當執行緒沒有中斷就繼續執行
			while (!Thread.currentThread().isInterrupted()) {
				try {
					int randomNum = random.nextInt(1000);
					// 將 randomNum 放到 queue 中
					queue.add(String.format("%03d", randomNum));
					System.out.println(queue);
					Thread.sleep(random.nextInt(500)); // 停 ms
				} catch (Exception e) {
					e.printStackTrace();
					Thread.currentThread().isInterrupted(); // 執行緒中斷
				}
			}
		}
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Random Number Display");
		JLabel label = new JLabel("000");
		label.setFont(new Font(label.getFont().getName(), Font.BOLD, 30));
		frame.add(label);
		frame.setSize(300, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		// 建立 ExecutorService
		ExecutorService executor = Executors.newFixedThreadPool(4);
		// 3 個 RandomNumberGenerator, 1 個 checkQueueThread
		executor.submit(new RandomNumberGenerator());
		executor.submit(new RandomNumberGenerator());
		executor.submit(new RandomNumberGenerator());
		
		// CheckQueueThread
		// 不斷的檢查 Queue 是否有資料
		executor.submit(() -> {
			while (!Thread.currentThread().isInterrupted()) {
				if(!queue.isEmpty()) {
					String numberString = queue.poll();
					System.out.println("numberString = " + numberString);
					// UI Thread 來更新 label
					SwingUtilities.invokeLater(() -> {
						label.setText(numberString);
					});
				}
				// 提升處理效率
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
					Thread.currentThread().isInterrupted(); // 執行緒中斷
				}
				
			}
		});
		
		
	}

}
