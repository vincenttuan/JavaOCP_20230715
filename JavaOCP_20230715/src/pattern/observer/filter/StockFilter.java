package pattern.observer.filter;

// 過濾"股價"
public class StockFilter implements Filter {

	@Override
	public boolean isWatch(String message) {
		// 過濾 message 中是否有指定關鍵字
		return message.contains("股價");
	}
	
}
