package day16;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
		// LocalDate Java 8 API, 具不可變的, 且是 thread-safe
		LocalDate today = LocalDate.of(2023, 9, 9);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		birthdays.forEach(birthStr -> {
			// 將日期字串轉 LocalDate
			LocalDate birthday = LocalDate.parse(birthStr, formatter);
			int age = today.getYear() - birthday.getYear();
			System.out.println(age);
		});
		
		List<Integer> ages = birthdays.stream()  // String stream
									  .mapToInt(birthStr -> {
										  LocalDate birthday = LocalDate.parse(birthStr, formatter);
										  int age = today.getYear() - birthday.getYear();
										  return age;
									  })  // int stream
									  .boxed() // int stream -> Integer stream 
									  .collect(Collectors.toList());
		System.out.println(ages);
		
	}
}
