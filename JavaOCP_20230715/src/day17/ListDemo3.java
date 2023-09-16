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
		
		// 請問"紅茶"整體銷售業績
		double redTeaSum = transactions.stream()
									   .filter(tx -> tx.getProduct().getName().equals("紅茶"))
									   .mapToDouble(tx -> tx.getQty() * tx.getProduct().getPrice())
									   .sum();
		System.out.printf("紅茶整體銷售業績 $%,.0f\n", redTeaSum);
		
		// 請問哪一個商品整體銷售業績最高?銷售業績=?
		String topName = transactions.stream()
				.map(tx -> tx.getProduct().getName()) // 取得所有商品(會有重複資料)
				.distinct() // 去除重複資料
				.max((name1, name2) -> {
					double sales1 = transactions.stream()
							.filter(tx -> tx.getProduct().getName().equals(name1))
							.mapToDouble(tx -> tx.getQty() * tx.getProduct().getPrice())
							.sum();
					double sales2 = transactions.stream()
							.filter(tx -> tx.getProduct().getName().equals(name2))
							.mapToDouble(tx -> tx.getQty() * tx.getProduct().getPrice())
							.sum();
					//return (int)(sales1 - sales2);
					return Double.compare(sales1, sales2);
				}) // 商品名稱兩兩相比
				.orElse("None");
		
		double topSum = transactions.stream()
				   .filter(tx -> tx.getProduct().getName().equals(topName))
				   .mapToDouble(tx -> tx.getQty() * tx.getProduct().getPrice())
				   .sum();
		
		System.out.printf("[%s]整體銷售業績最高 $%,.0f\n", topName, topSum);
		
		// -------------------------------------------------------------------------------
		
		String topName2 = transactions.stream()
				.map(tx -> tx.getProduct().getName()) // 取得所有商品(會有重複資料)
				.distinct() // 去除重複資料
				.max((name1, name2) -> {
					double sales1 = getSumByName(name1, transactions);
					double sales2 = getSumByName(name2, transactions);
					return Double.compare(sales1, sales2);
				}) // 商品名稱兩兩相比
				.orElse("None");
		
		double topSum2 = getSumByName(topName2, transactions);
		System.out.printf("[%s]整體銷售業績最高 $%,.0f\n", topName2, topSum2);
		
		// --------------------------------------------------------------------------------
		
		String lowName = transactions.stream()
				.map(tx -> tx.getProduct().getName()) // 取得所有商品(會有重複資料)
				.distinct() // 去除重複資料
				.min((name1, name2) -> {
					double sales1 = getSumByName(name1, transactions);
					double sales2 = getSumByName(name2, transactions);
					return Double.compare(sales1, sales2);
				}) // 商品名稱兩兩相比
				.orElse("None");
		double lowSum = getSumByName(lowName, transactions);
		System.out.printf("[%s]整體銷售業績最低 $%,.0f\n", lowName, lowSum);
	}
	
	// 取得商品整體銷售業績
	private static double getSumByName(String name, List<Transaction> transactions) {
		return transactions.stream()
		   .filter(tx -> tx.getProduct().getName().equals(name))
		   .mapToDouble(tx -> tx.getQty() * tx.getProduct().getPrice())
		   .sum();
	}
}
