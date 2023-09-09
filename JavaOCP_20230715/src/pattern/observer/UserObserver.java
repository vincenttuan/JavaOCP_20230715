package pattern.observer;

import pattern.observer.filter.Filter;

// 訂閱者(就是觀察者 Observer)
public class UserObserver implements Observer {
	private String name;
	private int priority; // 優先權(1~10)
	private Filter filter;
	
	public UserObserver(String name) {
		this.name = name;
		this.priority = 5;
	}
	
	public UserObserver(String name, int priority) {
		this.name = name;
		this.priority = priority;
	}
	
	public UserObserver(String name, int priority, Filter filter) {
		this.name = name;
		this.priority = priority;
		this.filter = filter;
	}
	
	@Override
	public void update(String message) {
		System.out.printf("%s 收到訊息: %s\n", name, message);
	}

	@Override
	public int getPriority() {
		return priority;
	}

	@Override
	public Filter getFilter() {
		return filter;
	}
	
}
