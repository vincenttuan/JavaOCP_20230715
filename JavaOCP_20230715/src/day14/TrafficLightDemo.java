package day14;

public class TrafficLightDemo {

	public static void main(String[] args) {
		TrafficLight trafficLight = TrafficLight.黃燈;
		System.out.println(trafficLight.getDuration());
		System.out.println(trafficLight);
		
		System.out.printf("%s有 %d 秒\n", trafficLight, trafficLight.getDuration());

	}

}
