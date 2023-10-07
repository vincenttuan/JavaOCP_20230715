package day23;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// 因為使用 synchronized 若遇到複雜的邏輯可能會發生死結
// 所以 Java 5 開始之後建議使用 ReentantLock
// lock() 上鎖 / unlock() 解鎖
public class BankAccount2 {
	private int balance; // 帳戶餘額
	private static final Lock lock = new ReentrantLock(); // 加入鎖
	
	public BankAccount2(int balance) {
		this.balance = balance;
	}
	
	// 提款
	public void withdraw(int amount) {
		lock.lock(); // 上鎖
		try {
			String tName = Thread.currentThread().getName();
			if(this.balance < amount) {
				System.out.printf("%s 提款 %d 失敗, 餘額 %d\n", tName, amount, this.balance);
				return;
			}
			// 模擬交易所花費的時間
			for(int i=0;i<Integer.MAX_VALUE;i++);
			// 扣抵餘額
			this.balance -= amount;
			System.out.printf("%s 提款 %d 成功, 餘額 %d\n", tName, amount, this.balance);
		} finally {
			lock.unlock(); // 解鎖
		}
	}
	
	// 存款
	public void deposit(int amount) {
		lock.lock(); // 上鎖
		try {
			String tName = Thread.currentThread().getName();
			// 模擬交易所花費的時間
			for(int i=0;i<Integer.MAX_VALUE;i++);
			// 加上餘額
			this.balance += amount;
			System.out.printf("%s 存款 %d 成功, 餘額 %d\n", tName, amount, this.balance);
		} finally {
			lock.unlock(); // 解鎖
		}
	} 
	
	
	// 主程式
	public static void main(String[] args) {
		BankAccount2 account = new BankAccount2(1000);
		
		// 建立數個執行緒用於提款
		new Thread(() -> account.withdraw(700), "提1").start();
		new Thread(() -> account.withdraw(500), "提2").start();
		new Thread(() -> account.withdraw(400), "提3").start();
		
		// 建立數個執行緒用於存款
		new Thread(() -> account.deposit(100), "存1").start();
		new Thread(() -> account.deposit(200), "存2").start();
		new Thread(() -> account.deposit(300), "存3").start();
		
		
	}
}
