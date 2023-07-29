package day03;

import java.util.Random;
import java.util.Scanner;

public class TTT {
	
	public static void main(String[] args) {
		//System.out.println('O'+'O'+'O'); // 237
		//System.out.println('X'+'X'+'X'); // 264
		char[] ttt = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
		printTTT(ttt);
		do {
			// User:
			if(!userPlay(ttt)) {
				continue;
			}
			// 印出結果
			printTTT(ttt);
			// 判定'O'是否賓果 ?
			if(checkWin('O', ttt)) {
				System.out.println("O Win");
				break;
			}
			
			// 判斷是否和局 ?
			if(checkFull(ttt)) {
				System.out.println("和局");
				break;
			}
			
			// PC:
			pcPlay(ttt);
			// 印出結果
			printTTT(ttt);
			// 判定'X'是否賓果 ?
			if(checkWin('X', ttt)) {
				System.out.println("X Win");
				break;
			}
			
		} while (true);
		
	}
	
	// User play
	private static boolean userPlay(char[] ttt) {
		System.out.print("請選擇位置0~8:");
		Scanner scanner = new Scanner(System.in);
		int idx = scanner.nextInt();
		// 檢查 idx 是否合法 ?
		if(idx < 0 || idx > 8 || ttt[idx] != ' ') {
			System.out.println("位置輸入不正確");
			return false;
		}
		ttt[idx] = 'O';
		return true;
	}
	
	// PC Play
	private static void pcPlay(char[] ttt) {
		Random random = new Random();
		int idx = 0;
		while (true) {
			idx = random.nextInt(ttt.length);
			if(ttt[idx] != ' ') {
				continue;
			}
			break;
		}
		ttt[idx] = 'X';
	}
	
	// 判輸贏
	private static boolean checkWin(char player, char[] ttt) {
		int score = (player == 'O' ? 237 : 264);
		boolean result = (ttt[0]+ttt[1]+ttt[2] == score || ttt[3]+ttt[4]+ttt[5] == score || ttt[6]+ttt[7]+ttt[8] == score ||
						  ttt[0]+ttt[3]+ttt[6] == score || ttt[1]+ttt[4]+ttt[7] == score || ttt[2]+ttt[5]+ttt[8] == score || 
						  ttt[0]+ttt[4]+ttt[8] == score || ttt[2]+ttt[4]+ttt[6] == score);
		return result;
	}
	
	// 印出棋盤
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
	
	// 判斷和局
	private static boolean checkFull(char[] ttt) {
		for(char c : ttt) {
			if(c == ' ') {
				return false;
			}
		}
		return true;
	}
	
}
