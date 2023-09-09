package pattern.observer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// 新聞訂閱
public class NewsSubject implements Subject {
	private List<Observer> users = new ArrayList<>(); // 集合動態陣列
	
	@Override
	public void add(Observer observer) {
		users.add(observer);
		// 根據 observer 的優先權來排序
		Collections.sort(users, Comparator.comparingInt(Observer::getPriority));
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
