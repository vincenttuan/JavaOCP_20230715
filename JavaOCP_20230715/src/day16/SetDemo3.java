package day16;

import java.util.LinkedHashSet;
import java.util.Set;

public class SetDemo3 {
	public static void main(String[] args) {
		// 員工生日列表如下:
		Set<String> birthdays = new LinkedHashSet<>();
		birthdays.add("1992-05-12");
		birthdays.add("1985-08-23");
		birthdays.add("2000-03-15");
		birthdays.add("1978-11-02");
		birthdays.add("1989-06-19");
		birthdays.add("2002-02-14");
		birthdays.add("1975-10-29");
		birthdays.add("1999-12-07");
		birthdays.add("1980-04-04");
		birthdays.add("1995-09-30");
		System.out.println(birthdays);
		
		// 請根據員工生日列表印出每一個人的年齡:
	}
}
