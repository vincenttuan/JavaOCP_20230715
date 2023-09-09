package pattern.observer;

public class Main2 {

	public static void main(String[] args) {
		// 3 個訂閱者(觀察者)
		Observer observer1 = new UserObserver("John", 3);
		Observer observer2 = new UserObserver("Mary", 1);
		Observer observer3 = new UserObserver("Rose", 2);
		
		// 1 個被訂閱者(被觀察者)
		Subject subject = new NewsSubject();
		
		// 訂閱
		subject.add(observer1);
		subject.add(observer2);
		subject.add(observer3);
		
		// 發送新聞 1
		subject.notifyMessage("今天天氣很好~");
		
		
	}

}
