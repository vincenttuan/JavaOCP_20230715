package day11;

public class CarDemo {

	public static void main(String[] args) {
		ACar car1 = new CUV();
		ACar car2 = new SRV();
		ToyCar car3 = new Tomico();
		ToyCar car4 = new ModelCar();
		
		car1.start();
		car2.start();
		car3.start();
		car4.start();
		
		car1.stop();
		car2.stop();
		car3.stop();
		car4.stop();
		
		car1.copyright();
		car2.copyright();
		car3.copyright();
		car4.copyright();
		
		// 分類
		Car[] cars = {car1, car2, car3, car4};
		ACar[] acars = {car1, car2};
		ToyCar[] toyCars = {car3, car4};
		
	}

}
