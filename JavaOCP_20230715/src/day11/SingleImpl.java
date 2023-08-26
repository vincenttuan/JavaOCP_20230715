package day11;

public class SingleImpl implements Single, Single.Nested {
	@Override
	public void call() {
		System.out.println("Call Me");
	}
	
	@Override
	public int calc(int x, int y) {
		return x + y;
	}
	
	@Override
	public void bar() {
		System.out.println("bar2");
	}
	
	public static void main(String[] args) {
		Single single = new SingleImpl();
		Single.foo();
		single.bar();
		System.out.println(single.calc(10, 20));
		((SingleImpl)single).call();
	}

	
}
