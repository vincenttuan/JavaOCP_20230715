package day24;

import java.security.MessageDigest;
import java.security.SecureRandom;

// Hash 加鹽(Salt)
public class SalaryHashAddSaltGenerator {

	public static void main(String[] args) throws Exception {
		// 定義一個密碼
		String password = "1234";
		
		// 生成鹽
		byte[] salt = new byte[16];
		SecureRandom secureRandom = new SecureRandom();
		secureRandom.nextBytes(salt);
		
		// 將鹽透過 16 進位的字串來表示
		String saltHexStr = KeyUtil.bytesToHex(salt);
		System.out.printf("鹽: %s\n", saltHexStr);
		
		// 利用 SHA-256 加密演算法來產生訊息摘要物件
		// 幫助我們生成密碼的 Hash
		MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
		
		// 加入鹽
		messageDigest.update(salt);
		
		// 將密碼進行 Hash
		byte[] hashedBytesPassword = messageDigest.digest(password.getBytes());
		
		// 將 byte[] -> 轉 Hex 字串
		String hashedStrPassword = KeyUtil.bytesToHex(hashedBytesPassword);
		
		// 印出 password 有加鹽的 hash
		System.out.printf("原始密碼: %s\n", password);
		System.out.printf("加鹽的 hash 密碼: %s\n", hashedStrPassword);
		
		// saltHexStr(鹽) 與 hashedStrPassword(加鹽的hash密碼) 要存入資料庫中
		/* 如下:
		 * 使用者資料表:
		 * +------+-----------+---------------+
		 * | user |   salt    |    hashPwd    |
		 * +------+-----------+---------------+
		 * | John | c43eb3c.. | ae94e3cfccd.. |
		 * +------+-----------+---------------+
		 * | Mary | 6d96349.. | d69e83058e1.. |
		 * +------+-----------+---------------+
		 * */
		String username = "john";
		String saltHexFromDB = KeyUtil.bytesToHex(salt);
		String hashPasswordFromDB = hashedStrPassword;
		
		// 使用者輸入密碼 1234
		String userPassword = "1234";
		// 1.根據 userPassword + saltHexFromDB 得到 hashPassword
		// 2.比較 hashPassword 與 hashPasswordFromDB 是否相等
		MessageDigest messageDigest2 = MessageDigest.getInstance("SHA-256");
		
		// 鹽加入
		byte[] saltFromDB = KeyUtil.hexStringToByteArray(saltHexFromDB);
		messageDigest2.update(saltFromDB);
		
		// 在加 userPassword 得到 hashPassword
		hashedBytesPassword = messageDigest2.digest(userPassword.getBytes());
		hashedStrPassword = KeyUtil.bytesToHex(hashedBytesPassword);
		
		System.out.println();
		System.out.printf("加鹽的 hash 密碼: %s\n", hashedStrPassword);
		
		if(hashPasswordFromDB.equals(hashedStrPassword)) {
			System.out.println("密碼比對成功");
		} else {
			System.out.println("密碼比對失敗");
		}
	}

}
