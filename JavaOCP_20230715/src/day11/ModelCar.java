package day11;

public class ModelCar extends ToyCar {
	
	@Override
	public void start() {
		System.out.println("不動-靜態展示");
	}
	 
	@Override
	protected void toyType() {
		System.out.println("模型車");
	}
}
 
