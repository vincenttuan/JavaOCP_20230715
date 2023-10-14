package day25;

import java.io.File;

import javax.crypto.SecretKey;

/*
 * 
 * 當我們考慮使用 MAC (Message Authentication Code) 而不是單純的 Hash，
 * 主要的情境是當我們想要確保消息不只是保持完整，還要確保它是從特定的發送者傳來的。
 * 使用 MAC 的時候，我們結合了訊息和一個秘密鑰匙來生成一個摘要。
 * 只有知道那把鑰匙的人才能生成或驗證這個摘要。

 * 以下是一個場景：假設你(john)是一家公司的財務部門的員工，你每月都會從 HR 部門收到你的薪資明細 john_salary.txt。
 * 為了確保這個消息的真實性和完整性，HR 使用一個他們和你都知道的秘密鑰匙生成 MAC，然後發送給你。
 * 你收到後，也使用同一把鑰匙去驗證 MAC，以確保訊息沒有被更改，且真的是從 HR 部門傳來的。
 * 
*/
public class HRSalaryMacCreator {

	public static void main(String[] args) throws Exception {
		// 薪資檔案位置
		String filePath = "src/day25/john_salary.txt";
		// 密鑰檔案位置
		String keyPath = "src/day25/macKey.key";
		
		// 判斷若 keyPath 已經存在則直接取得金鑰, 反之則創建金鑰
		SecretKey macKey = null;
		if(new File(keyPath).exists()) {
			// 密鑰存在則透過金鑰檔案位置得到金鑰
			macKey = KeyUtil.getSecretKeyFromFile("HmacSHA256", keyPath);
			System.out.println("密鑰取得成功!");
		} else {
			// 密鑰不存在則生成一個密鑰(秘密鑰匙)
			macKey = KeyUtil.generateKeyForHmac();
		
			// 保存密鑰, 讓 john 可以得到相同的密鑰
			KeyUtil.saveSecretKeyToFile(macKey, keyPath);
			System.out.println("密鑰儲存成功: " + keyPath);
		}
		
		// 根據 "HmacSHA256" + macKey + 薪資檔案位置 filePath 來生成 macValue
		String macValue = KeyUtil.generateMac("HmacSHA256", macKey, filePath);
		System.out.println("mac: " + macValue);

	}

}
