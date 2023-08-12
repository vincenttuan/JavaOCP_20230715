package day05;

//物件導向: 蛋糕設計圖
public class Cake {
	private String name; // 蛋糕名稱
	private int price; // 蛋糕價格
	private int sweetRating; // 甜度分級(0~50)
	
	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(int price) {
		if(price >= 0 && price <= 1000) {
			this.price = price;
		}
	}

	public void setSweetRating(int sweetRating) {
		if(sweetRating >= 0 && sweetRating <= 50) {
			this.sweetRating = sweetRating;
		}
	}

	// 顯示蛋糕的方法
	public void display() {
		System.out.printf("%s $%d 甜度 %d 級\n", name, price, sweetRating);
	}
}
