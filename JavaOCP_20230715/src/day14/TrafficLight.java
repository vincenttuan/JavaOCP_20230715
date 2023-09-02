package day14;

public enum TrafficLight {
	紅燈(60), 黃燈(10), 綠燈(50);
	
	private int duration;
	
	TrafficLight(int duration) {  // enum 建構子一律是 private, 若沒寫編譯時會自動加入
		this.duration = duration;
	}
	
	public int getDuration() {
		return duration;
	}
}
