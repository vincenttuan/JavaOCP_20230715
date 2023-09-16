package day17;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import static java.lang.System.out;

public class ListDemo3 {

	public static void main(String[] args) throws IOException {
		List<String> lines = Files.readAllLines(Paths.get("src/day17/sales_data.txt"));
		System.out.println(lines.size());
		lines.forEach(out::println);

	}

}
