package day18;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
 List<Map<String, String>>
 [
 	{date=2023/1/1, product=紅茶, price=30, qty=50, city=台北, branch=信義分店},
 	{date=2023/1/1, product=紅茶, price=30, qty=50, city=台北, branch=信義分店},
 	{date=2023/1/1, product=紅茶, price=30, qty=50, city=台北, branch=信義分店},
 	{date=2023/1/1, product=紅茶, price=30, qty=50, city=台北, branch=信義分店},
 	{date=2023/1/1, product=紅茶, price=30, qty=50, city=台北, branch=信義分店},
 	...
 ]
  
 * */
public class MapDemo3 {

	public static void main(String[] args) throws IOException {
		List<Map<String, String>> sales = new ArrayList<>();
		
		List<String> lines = Files.readAllLines(Paths.get("src/day18/sales_data.txt"));
		//date,product,price,qty,city,branch
		String[] keys = lines.get(0).split(",");
		
		//-- Java 7 -------------------------------------------------------------------------
		for(int i=1;i<lines.size();i++) {
			//2023/1/1,紅茶,30,50,台北,信義分店
			String[] values = lines.get(i).split(",");
			if(keys.length == values.length) {
				Map<String, String> map = new LinkedHashMap<>();
				// 依序將 key 與 value 加入到 map 集合
				for(int k=0;k<keys.length;k++) {
					map.put(keys[k], values[k]);
				}
				sales.add(map);
			}
		}
		System.out.println(sales);
		//-- clear() ------------------------------------------------------------------------
		sales.clear();
		System.out.println(sales);
		//-- Java 8 -------------------------------------------------------------------------
		sales = lines.stream()
				.skip(1) // 跳過第一筆
				.map(line -> line.split(",")) // 元素由 String -> String[]
				.filter(values -> values.length == keys.length)
				.map(values -> IntStream.range(0, keys.length)
						.boxed()
						.collect(Collectors.toMap(i -> keys[i], i -> values[i], (v1, v2) -> v1, LinkedHashMap::new)))
				.collect(Collectors.toList());
		System.out.println(sales);		
				
		
	}

}




