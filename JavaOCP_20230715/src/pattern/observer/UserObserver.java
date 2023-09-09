package pattern.observer;

// 訂閱者(就是觀察者 Observer)
public class UserObserver implements Observer {
	private String name;
	
	public UserObserver(String name) {
		this.name = name;
	}
	
	@Override
	public void update(String message) {
		System.out.printf("%s 收到訊息: %s\n", name, message);
	}
	
}
