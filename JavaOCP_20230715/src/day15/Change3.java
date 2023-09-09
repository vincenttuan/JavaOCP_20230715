package day15;

public class Change3 {
	
	// 定義一個 Money 這個 enum 來代表各種紙鈔與硬幣的面值
	enum Money {
		NOTE_500(500), NOTE_100(100), // 紙鈔
		COIN_50(50), COIN_10(10), COIN_5(5), COIN_1(1); // 硬幣
		
		private final int value;
		
		private Money(int value) {
			this.value = value;
		}
		
		public int getValue() {
			return value;
		}
	}
	
	public static void main(String[] args) {
		// 請自行完成

	}

}
