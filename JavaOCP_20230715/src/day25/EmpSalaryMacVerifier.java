package day25;

import javax.crypto.SecretKey;

/*
 * 
 * 用於驗證薪資明細的 MAC
 * 
 * 證明成功實施了 MAC 驗證策略，並且可以正確地驗證您的薪資明細的完整性和來源。
 * 使用這樣的策略可以確保只有擁有正確 MAC 密鑰的人（在這個例子中是 HR 部門）
 * 才能生成有效的 MAC，而其他人則不能。
 * 
 * 這是一個非常重要的安全策略，特別是在涉及敏感資訊（如薪資明細）的場合。
 * 只要保護好您的密鑰，就可以確保消息的真實性和完整性。
*/
public class EmpSalaryMacVerifier {

	public static void main(String[] args) throws Exception {
		// 薪資檔案位置
		String filePath = "src/day25/john_salary.txt";
		// 密鑰檔案位置
		String keyPath = "src/day25/macKey.key";
		// 得到密鑰
		SecretKey macKey = KeyUtil.getSecretKeyFromFile("HmacSHA256", keyPath);
		// 生成 mac
		String macValue = KeyUtil.generateMac("HmacSHA256", macKey, filePath);
		
		// HR 所生成的 mac
		String hrMac = "dbdcb69904f1ac93bc224289e9151d3b5def346c631f7d79c503a12857334fbe";
		
		// 拿你所生成的 macValue 與 HR 部門所生成 hrMac 進行比對
		if(macValue.equals(hrMac)) {
			System.out.println("薪資明細檔驗證成功. 資料沒有受到修改, 資料是從 HR 發送");
		} else {
			System.out.println("薪資明細檔驗證失敗 !");
		}
		
		
	}

}
