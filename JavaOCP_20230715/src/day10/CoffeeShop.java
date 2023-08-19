package day10;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;

public class CoffeeShop {

	public static void main(String[] args) {
		Coffee espresso = new Espresso("義式濃縮", 35);
		Coffee cappuccino = new Cappuccino("卡布奇諾", 55);
		Coffee latte = new Latte("拿鐵咖啡", 50);
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
		
		// 針對價格的統計資料
		IntSummaryStatistics stat = Arrays.stream(coffees).mapToInt(Coffee::getPrice).summaryStatistics();
		System.out.println(stat);
		System.out.printf("數量: %d\n", stat.getCount());
		System.out.printf("總價: %d\n", stat.getSum());
		System.out.printf("平均: %.1f\n", stat.getAverage());
		System.out.printf("最高: %d\n", stat.getMax());
		System.out.printf("最低: %d\n", stat.getMin());
		
		// 印出最高價的咖啡名稱-透過統計數據
		String highestName = Arrays.stream(coffees)
								   .filter(coffee -> coffee.getPrice() == stat.getMax()) // 過濾出最高價
								   .findAny()  // 得到 Optional<Coffee>
								   .get()      // 得到 Coffee 物件
								   .getName(); // 取得 Coffee 名字
		
		System.out.printf("最高價的咖啡名稱: %s\n", highestName);
		
		// 印出最高價的咖啡名稱-不透過統計數據
		highestName = Arrays.stream(coffees)
							.max(Comparator.comparingInt(Coffee::getPrice))  // 取得最高價的 Coffee 物件
							.map(Coffee::getName)  // 由 Coffee 物件轉換為咖啡名字
							.orElse("無此咖啡");
		
		System.out.printf("最高價的咖啡名稱: %s\n", highestName);
		
		
	}

}
