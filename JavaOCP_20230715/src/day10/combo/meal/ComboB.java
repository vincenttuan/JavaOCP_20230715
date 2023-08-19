package day10.combo.meal;

import day10.Cake;
import day10.ChocolateCake;
import day10.Latte;
import day10.combo.Combo;

public class ComboB extends Combo {

	public ComboB() {
		super("B餐", new ChocolateCake(), new Latte());
	}
	
}
