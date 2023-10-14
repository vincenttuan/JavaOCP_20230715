package day24;

import java.io.FileInputStream;
import java.security.MessageDigest;

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
}
