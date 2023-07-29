package day03;

import java.util.Random;
import java.util.Scanner;

public class TTT {
	
	public static void main(String[] args) {
		Random random = new Random();
		char[] ttt = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
		printTTT(ttt);
		do {
			// User:
			System.out.print("請選擇位置0~8:");
			Scanner scanner = new Scanner(System.in);
			int idx = scanner.nextInt();
			// 檢查 idx 是否合法 ?
			if(idx < 0 || idx > 8 || ttt[idx] != ' ') {
				System.out.println("位置輸入不正確");
				continue;
			}
			ttt[idx] = 'O';
			
			// PC:
			while (true) {
				idx = random.nextInt(ttt.length);
				if(ttt[idx] != ' ') {
					continue;
				}
				break;
			}
			ttt[idx] = 'X';
			
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
