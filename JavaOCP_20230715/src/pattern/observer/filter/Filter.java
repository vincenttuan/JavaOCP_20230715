package pattern.observer.filter;

public interface Filter {
	boolean isWatch(String message); // 是否關注
}
