package day24;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class KeyUtil {
	/**
     * 根據給定的文件路徑生成 SHA-256 雜湊值。
     * 
     * @param filepath 文件的路徑。
     * @return 返回文件內容的 SHA-256 雜湊值，以十六進制字符串格式表示。
     * 如果在讀取文件或生成雜湊時出現錯誤，則返回 null。
     */
    public static String generateFileHash(String filepath) {
        try (FileInputStream fis = new FileInputStream(filepath)) {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // 創建一個大小為 1024 字節的緩衝區用於讀取文件
            byte[] buffer = new byte[1024];
            int bytesRead = -1;

            // 讀取文件，並更新雜湊
            while ((bytesRead = fis.read(buffer)) != -1) {
                digest.update(buffer, 0, bytesRead);
            }

            // 計算並返回雜湊值
            return bytesToHex(digest.digest());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * 可將字節陣列轉換為十六進制格式的字符串。
     * 這通常用於方便地顯示二進制數據，如數字簽名、摘要或加密的數據。
     * 
     * @param bytes 要轉換的字節陣列
     * @return 表示給定字節的十六進制格式的字符串
     */
    public static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
    
    /**
     * 要從十六進制格式的雜湊字串轉回 byte[]
     * 
     * @return 返回 byte[]。
     */
    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }
    
    /**
     * 使用給定的算法和金鑰生成訊息認證碼 (MAC)。
     * 
     * @param algorithm 使用的 MAC 算法 (例如: "HmacSHA256")
     * @param key 使用的密鑰來生成 MAC
     * @param message 要生成 MAC 的原始訊息
     * @return 訊息的 MAC 值
     * @throws Exception 當有錯誤發生 (例如: 不支援的算法)
     */
    public static byte[] generateMac(String algorithm, SecretKey key, byte[] message) throws Exception {
        Mac mac = Mac.getInstance(algorithm);
        mac.init(key);
        return mac.doFinal(message);
    }
    
    /**
     * 用指定的演算法和鑰匙生成訊息驗證碼 (MAC)。
     *
     * @param algorithm 用於 MAC 的演算法，例如 "HmacSHA256"
     * @param key 用於生成 MAC 的秘密鑰匙
     * @param filepath 要生成 MAC 的文件的路徑
     * @return 返回文件的 MAC 值，格式為十六進制字符串
     * @throws Exception 如果在讀取文件或生成 MAC 時出現任何錯誤
     */
    public static String generateMac(String algorithm, SecretKey key, String filepath) throws Exception {
        Mac mac = Mac.getInstance(algorithm);
        mac.init(key);

        byte[] fileBytes = Files.readAllBytes(Paths.get(filepath));
        byte[] macBytes = mac.doFinal(fileBytes);

        return bytesToHex(macBytes);
    }
    
    // 保存密鑰
    public static void saveSecretKeyToFile(SecretKey key, String path) throws IOException {
        byte[] keyBytes = key.getEncoded();
        Files.write(Paths.get(path), keyBytes);
    }
    
    // 取得密鑰
    public static SecretKey getSecretKeyFromFile(String algorithm, String path) throws IOException {
        byte[] keyBytes = Files.readAllBytes(Paths.get(path));
        return new SecretKeySpec(keyBytes, algorithm);
    }

    
    /**
     * 生成一個適用於 HmacSHA256 的密鑰。
     * 
     * Hmac - "Hash-based Message Authentication Code" 的縮寫。它是一種特定的方式，
     * 用於檢查訊息的完整性並提供身份驗證，特別是在密碼學中。
     * Hmac 需要一個加密哈希函數和一個密鑰作為其兩個主要參數。
     * 
     * SHA256 - 這是一個加密哈希函數，
     * 屬於 SHA-2（Secure Hash Algorithm 2）家族。256 表示輸出的摘要/哈希長度是 256 位。
     * 
     * 除了 HmacSHA256 外，還有其他的 Hmac 設定，這些設定主要根據所使用的加密哈希函數而有所不同。以下是一些常見的選項：
     * HmacSHA1 - 使用 SHA-1 加密哈希函數。
     * HmacSHA384 - 使用 SHA-2 家族中的 SHA-384 函數。
     * HmacSHA512 - 使用 SHA-2 家族中的 SHA-512 函數。
     * 
     * @return 用於 HmacSHA256 的 SecretKey
     * @throws Exception 當生成密鑰時發生錯誤 (例如: 不支援的算法)
     */
    public static SecretKey generateKeyForHmac() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA256");
        return keyGenerator.generateKey();
    }
    
}
