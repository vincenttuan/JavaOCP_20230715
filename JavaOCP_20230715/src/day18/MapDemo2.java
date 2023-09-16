package day18;

import java.util.LinkedHashMap;
import java.util.Map;

public class MapDemo2 {

	public static void main(String[] args) {
		Map<String, Integer> grades = new LinkedHashMap<>();
		grades.put("數學", 88);
		grades.put("生物", 76);
		grades.put("化學", 84);
		grades.put("體育", 95);
		grades.put("美術", 78);
		
		// 請完成以下的題目：
		// 1. 請問小明在 "化學" 科目的成績是多少？
		
		// 2. 如果小明想查詢他的 "物理" 成績，但還未被記錄，請返回一個預設成績 70 分。
		
		// 3. 小明參加了學校的 "音樂" 考試並得到 82 分，請將這筆資料加入 grades 中。
		
		// 4. 小明參加了 "數學" 的補考，新的成績為 92 分。但老師說補考成績不會覆蓋原來的分數。請使用適當的方法加入這筆資料。
		
		// 5. 使用 compute 方法，如果 "生物" 的成績低於 80 分，則將其調整至 80 分。
		
		// 6. 如果小明的 "資訊" 科目成績尚未記錄，請加入 grades 並給予 85 分。
		
		// 7. 小明在 "體育" 科目表現出色，老師給予他 3 分的獎勵分。請使用 merge 方法更新這筆資料。
		
		// 8. 請計算小明在這些科目的總分和平均分數。
		
		// 9. 使用 Java Stream API，找出小明得分最高的科目名稱。
		
	}

}
