package day10;

import day10.combo.Combo;
import day10.combo.ComboF;
import day10.combo.meal.ComboA;
import day10.combo.meal.ComboB;

public class CoffeeShop2 {

	public static void main(String[] args) {
		// A
		Combo comboA = new ComboA();
		comboA.setCoffee(new GreenTeaLatte());
		// B
		Combo comboB = new ComboB();
		// F
		ComboF comboF = new ComboF();
		comboF.setCake(new CheeseCake());
		comboF.setCoffee(new VanillaLatte());
		
		System.out.printf("%s %s $%d %s $%d\n", 
				comboA.getName(), 
				comboA.getCake().getName(), comboA.getCake().getPrice(),
				comboA.getCoffee().getName(), comboA.getCoffee().getPrice());
		
		System.out.printf("%s %s $%d %s $%d\n", 
				comboB.getName(), 
				comboB.getCake().getName(), comboB.getCake().getPrice(),
				comboB.getCoffee().getName(), comboB.getCoffee().getPrice());
		
		System.out.printf("%s %s $%d %s $%d\n", 
				comboF.getName(), 
				comboF.getCake().getName(), comboF.getCake().getPrice(),
				comboF.getCoffee().getName(), comboF.getCoffee().getPrice());
	}

}
