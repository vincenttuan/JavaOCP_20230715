package day25;

import java.util.Arrays;

import javax.crypto.SecretKey;

/**
 * Message Authentication Code (MAC) 是一種使用密鑰的哈希算法，
 * 主要用於確認訊息的完整性和認證性。
 * 
 * 使用MAC的典型場景是：當傳送方發送一條訊息，他會生成一個MAC，並將MAC與訊息一起發送。
 * 接收方在接收到訊息後，可以使用相同的密鑰生成一個新的MAC，並與傳送的MAC進行比對，
 * 以驗證訊息的完整性和來源。
 */
public class MACExample {
	public static void main(String[] args) throws Exception {
		// 定義一個薪資訊息
		String message = "$88000";
		
		/**
         * 產生一把專用於 HMAC (Hash-based Message Authentication Code) 的密鑰。
         * HMAC 是一種特殊類型的MAC，它使用特定的哈希函數和密鑰。
         */
		SecretKey macKey = KeyUtil.generateKeyForHmac();
		
		// 指定 HmacSHA256 哈希函數 + macKey 得到 MAC 值
		byte[] macValue = KeyUtil.generateMac("HmacSHA256", macKey, message.getBytes());
		
		// 印出 macValue 16進位的內容
		System.out.println("mac code: " + KeyUtil.bytesToHex(macValue));
		
		// 在實際的應用中，當接收方收到訊息和 MAC 值時，他將執行以下驗證：
		// 1. 使用相同的密鑰和訊息生成一個新的 MAC
		byte[] comparedMacValue = KeyUtil.generateMac("HmacSHA256", macKey, message.getBytes());
		
		// 2. 比對接收到的 MAC 和新生成的 MAC 是否相同
		if(Arrays.equals(macValue, comparedMacValue)) {
			System.out.println("MAC 驗證成功 ! (確認訊息的完整性和認證性[來源也合法])");
		} else {
			System.out.println("MAC 驗證失敗 !");
		}
	}	
}
