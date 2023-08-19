package day10;

import java.util.Arrays;

public class CoffeeShop {

	public static void main(String[] args) {
		Coffee espresso = new Espresso("義式濃縮", 35);
		Coffee cappuccino = new Cappuccino("卡布奇諾", 55);
		Coffee latte = new Latte("拿鐵", 50);
		Coffee vanillaLatte = new VanillaLatte();
		Coffee greenTeaLatte = new GreenTeaLatte();
		Coffee matchaLatte = new MatchaLatte();
		
		Coffee[] coffees = {
				espresso, cappuccino, latte,
				vanillaLatte, greenTeaLatte, matchaLatte
		};
		
		Arrays.stream(coffees)
			  .forEach(coffee -> {
				  System.out.printf("%s $%d 烘培方式:", coffee.getName(), coffee.getPrice());
				  coffee.roastMethod();
			  });

	}

}
