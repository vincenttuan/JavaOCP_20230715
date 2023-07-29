package day03;

import java.util.Random;
import java.util.Scanner;

public class TTT {
	
	public static void main(String[] args) {
		//System.out.println('O'+'O'+'O'); // 237
		//System.out.println('X'+'X'+'X'); // 264
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
			// 印出結果
			printTTT(ttt);
			// 判定'O'是否賓果 ?
			if(ttt[0]+ttt[1]+ttt[2] == 237 || ttt[3]+ttt[4]+ttt[5] == 237 || ttt[6]+ttt[7]+ttt[8] == 237 ||
			   ttt[0]+ttt[3]+ttt[6] == 237 || ttt[1]+ttt[4]+ttt[7] == 237 || ttt[2]+ttt[5]+ttt[8] == 237 || 
			   ttt[0]+ttt[4]+ttt[8] == 237 || ttt[2]+ttt[4]+ttt[6] == 237) {
				System.out.println("O Win");
				break;
			}
			
			// 判斷是否和局 ?
			if(checkFull(ttt)) {
				System.out.println("和局");
				break;
			}
			
			// PC:
			while (true) {
				idx = random.nextInt(ttt.length);
				if(ttt[idx] != ' ') {
					continue;
				}
				break;
			}
			ttt[idx] = 'X';
			// 印出結果
			printTTT(ttt);
			// 判定'X'是否賓果 ?
			if(ttt[0]+ttt[1]+ttt[2] == 264 || ttt[3]+ttt[4]+ttt[5] == 264 || ttt[6]+ttt[7]+ttt[8] == 264 ||
			   ttt[0]+ttt[3]+ttt[6] == 264 || ttt[1]+ttt[4]+ttt[7] == 264 || ttt[2]+ttt[5]+ttt[8] == 264 || 
			   ttt[0]+ttt[4]+ttt[8] == 264 || ttt[2]+ttt[4]+ttt[6] == 264) {
				System.out.println("X Win");
				break;
			}
			
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
	
	private static boolean checkFull(char[] ttt) {
		for(char c : ttt) {
			if(c == ' ') {
				return false;
			}
		}
		return true;
	}
	
}
