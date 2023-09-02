package day14;

// 硬幣只有 1, 5, 10, 50
public enum Coin {
	一元(1), 五元(5), 拾(10), 二十(20), 五十(50);
	
	private int value;
	
	private Coin(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
}
