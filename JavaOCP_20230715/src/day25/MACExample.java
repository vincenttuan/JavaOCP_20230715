package day25;

/**
 * Message Authentication Code (MAC) 是一種使用密鑰的哈希算法，
 * 主要用於確認訊息的完整性和認證性。
 * 
 * 使用MAC的典型場景是：當傳送方發送一條訊息，他會生成一個MAC，並將MAC與訊息一起發送。
 * 接收方在接收到訊息後，可以使用相同的密鑰生成一個新的MAC，並與傳送的MAC進行比對，
 * 以驗證訊息的完整性和來源。
 */
public class MACExample {
	public static void main(String[] args) {
		
	}
}
