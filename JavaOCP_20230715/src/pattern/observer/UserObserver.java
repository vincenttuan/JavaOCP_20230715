package pattern.observer;

// 訂閱者(就是觀察者 Observer)
public class UserObserver implements Observer {
	private String name;
	private int priority; // 優先權(1~10)
	
	public UserObserver(String name) {
		this.name = name;
		this.priority = 5;
	}
	
	public UserObserver(String name, int priority) {
		this.name = name;
		this.priority = priority;
	}
	
	@Override
	public void update(String message) {
		System.out.printf("%s 收到訊息: %s\n", name, message);
	}

	@Override
	public int getPriority() {
		return priority;
	}
	
}
