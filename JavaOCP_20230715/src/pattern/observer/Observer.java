package pattern.observer;

import pattern.observer.filter.Filter;

// 觀察者 Observer
public interface Observer {
	void update(String message); // 更新通知
	int getPriority(); // 取得優先權(1..10)
	Filter getFilter(); // 取得關注/過濾
}
