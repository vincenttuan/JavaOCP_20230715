package day11;

public class CarDemo {

	public static void main(String[] args) {
		Car car1 = new CUV();
		Car car2 = new SRV();
		Car car3 = new Tomico();
		Car car4 = new ModelCar();
		
		car1.start();
		car2.start();
		car3.start();
		car4.start();
		
		car1.stop();
		car2.stop();
		car3.stop();
		car3.stop();
		
		car1.copyright();
		car2.copyright();
		car3.copyright();
		car4.copyright();

	}

}
