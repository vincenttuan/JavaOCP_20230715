package day26;

public class HttpClientDemo {

	public static void main(String[] args) {
		String city = "taoyuan";
		String country = "TW";
		String appid = "2e7c38444416f91b223a919462124db4";
		String urlPath = "https://api.openweathermap.org/data/2.5/weather?q=%s,%s&appid=%s";
		urlPath = String.format(urlPath, city, country, appid);
		
		

	}

}
