package pattern.observer;

import pattern.observer.filter.Filter;
import pattern.observer.filter.StockFilter;
import pattern.observer.filter.WeatherFilter;

public class Main3 {

	public static void main(String[] args) {
		// Filetr 過濾關注
		Filter weatherFilter = new WeatherFilter();
		Filter stockFilter = new StockFilter();
		
		// 3 個訂閱者(觀察者)
		Observer observer1 = new UserObserver("John", 3);
		Observer observer2 = new UserObserver("Mary", 1, weatherFilter);
		Observer observer3 = new UserObserver("Rose", 2);
		Observer observer4 = new UserObserver("Jack", 2, stockFilter);
		Observer observer5 = new UserObserver("Lisa", 2, stockFilter);
		
		// 1 個被訂閱者(被觀察者)
		Subject subject = new NewsSubject();
		
		// 訂閱
		subject.add(observer1);
		subject.add(observer2);
		subject.add(observer3);
		subject.add(observer4);
		subject.add(observer5);
		
		// 發送新聞 1
		subject.notifyMessage("今天天氣很好~");
		subject.notifyMessage("台積電股價:650");
		
		
	}

}
