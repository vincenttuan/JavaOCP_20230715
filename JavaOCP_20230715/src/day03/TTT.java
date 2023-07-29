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
		System.out.println("-------------");
		for(int i = 0; i < ttt.length ;i++) {
			if(i == 0)System.out.print("|");
			System.out.print(" " + ttt[i] +" |");
			if(i % 3 == 2) {
				System.out.println("\n-------------");
				if(i != ttt.length-1)System.out.print("|");
			}
		}
	}
	
}
