package day23;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// 火車訂票管理
public class TrainTicketSystem {
	private int availableTickets; // 火車票庫存
	private static final Lock lock = new ReentrantLock();
	
	public TrainTicketSystem(int availableTickets) {
		this.availableTickets = availableTickets;
	}
	
	// 訂火車票
	public void bookTicket(int quantity) {
		lock.lock(); // 上鎖
		try {
			String tName = Thread.currentThread().getName();
			if(availableTickets < quantity) {
				System.out.printf("%s 要訂 %d 張票, 但票量不足, 現有票量: %d\n", 
						tName, quantity, availableTickets);
				return;
			}
			// 模擬交易所花費的時間
			for(int i=0;i<Integer.MAX_VALUE;i++);
			
			// 減少票量庫存
			availableTickets -= quantity;
			System.out.printf("%s 訂購成功 %d 張票, 剩餘票量: %d\n", 
					tName, quantity, availableTickets);
		} finally {
			lock.unlock(); // 解鎖
		}
	}
	
	public static void main(String[] args) {
		TrainTicketSystem ticketSystem = new TrainTicketSystem(10);
		
		// 客戶訂票
		new Thread(() -> ticketSystem.bookTicket(3), "客戶A").start();
		new Thread(() -> ticketSystem.bookTicket(5), "客戶B").start();
		new Thread(() -> ticketSystem.bookTicket(4), "客戶C").start();
		new Thread(() -> ticketSystem.bookTicket(2), "客戶D").start();
	}
}
