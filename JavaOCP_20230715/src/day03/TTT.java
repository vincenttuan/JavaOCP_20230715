package day03;

import java.util.Scanner;

public class TTT {
	
	public static void main(String[] args) {
		char[] ttt = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
		printTTT(ttt);
		int count = 0;
		do {
			System.out.print("請選擇位置0~8:");
			Scanner scanner = new Scanner(System.in);
			int idx = scanner.nextInt();
			if(count++ % 2 == 0) {
				ttt[idx] = 'O';
			} else {
				ttt[idx] = 'X';
			}
			printTTT(ttt);
		} while (true);
		
	}
	
	private static void printTTT(char[] ttt) {
		for(int i=0;i<ttt.length;i++) {
			System.out.print(ttt[i]);
			if(i % 3 == 2 && i < 8) {
				System.out.println("\n---");
			}
		}
		System.out.println("\n........");
	}
	
}
