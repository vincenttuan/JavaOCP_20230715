package day17;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import static java.lang.System.out;

public class ListDemo3 {

	public static void main(String[] args) throws IOException {
		List<String> lines = Files.readAllLines(Paths.get("src/day17/sales_data.txt"));
		System.out.println(lines.size());
		//lines.forEach(out::println);
		
		List<Transaction> transactions = new ArrayList<>();
		// 定義一個客製化日期格式
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/M/d");
		for(int i=1;i<lines.size();i++) {
			//2023/1/1,紅茶,30,50,台北,信義分店
			String[] parts = lines.get(i).split(",");
			
			LocalDate date = LocalDate.parse(parts[0], formatter);
			String name = parts[1];
			double price = Double.parseDouble(parts[2]);
			int qty = Integer.parseInt(parts[3]);
			String city = parts[4];
			String branch = parts[5];
			
			Product product = new Product(name, price);
			Location location = new Location(city, branch);
			Transaction transaction = new Transaction(date, qty, product, location);
			
			// 加入到 transactions 集合中
			transactions.add(transaction);
		}
		
		System.out.println(transactions.size());
		//System.out.println(transactions);
		
		// 分析
		// 整體銷售業績
		double sum = transactions.stream()
								 .mapToDouble(tx -> tx.getQty() * tx.getProduct().getPrice())
								 .sum();
		System.out.printf("整體銷售業績 $%,.0f\n", sum);
		
	}

}
