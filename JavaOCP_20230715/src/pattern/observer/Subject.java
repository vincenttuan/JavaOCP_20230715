package pattern.observer;

// 被觀察者 Observable
public interface Subject {
	void add(Observer observer); // 訂閱/觀察者(會員)加入
	void remove(Observer observer); // 取消訂閱/觀察者(會員)移除
	void notifyMessage(String message); // 發送通知
	
}
