package day11;

interface B {
	void bell();
}

interface C {
	void call();
}

public interface A extends B, C {
	void action();
}
