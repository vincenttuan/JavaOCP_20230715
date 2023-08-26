package day11;

public class CarDemo {

	public static void main(String[] args) {
		Car car1 = new CUV();
		Car car2 = new SRV();
		
		car1.start();
		car2.start();
		car1.stop();
		car2.stop();
		
		car1.copyright();
		car2.copyright();

	}

}
