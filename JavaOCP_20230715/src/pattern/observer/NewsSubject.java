package pattern.observer;

import java.util.ArrayList;
import java.util.List;

// 新聞訂閱
public class NewsSubject implements Subject {
	private List<Observer> users = new ArrayList<>(); // 集合動態陣列
	
	@Override
	public void add(Observer observer) {
		users.add(observer);
	}

	@Override
	public void remove(Observer observer) {
		users.remove(observer);
	}

	@Override
	public void notifyMessage(String message) {
		for(Observer user : users) {
			user.update(message);
		}
	}
	
}
