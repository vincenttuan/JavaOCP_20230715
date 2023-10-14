package day26;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import javax.net.ssl.StandardConstants;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class HttpClientDemo {

	public static void main(String[] args) throws Exception {
		String city = "taoyuan";
		String country = "TW";
		String appid = "2e7c38444416f91b223a919462124db4";
		String urlPath = "https://api.openweathermap.org/data/2.5/weather?q=%s,%s&appid=%s";
		urlPath = String.format(urlPath, city, country, appid);
		
		System.out.println(urlPath);
		
		// 1. 使用 Java 11 的 HttpClient 來取得 JSON string 並印出
		HttpClient client = HttpClient.newHttpClient();
		
		// 2. 建立請求
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(urlPath))
				.build();
		
		// 3. 傳送 + 得到回應
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		String jsonString = response.body();
		System.out.println(jsonString);
		
		// 4. 使用 Gson 分析 JSON 物件 > main 物件 > temp 屬性資料
		JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
		JsonObject mainObject = jsonObject.getAsJsonObject("main");
		double temp = mainObject.get("temp").getAsDouble() - 273.15;
		System.out.printf("現在溫度: %.1f °C\n", temp);
		
		// 5. 下載 icon 並存檔
		//String icon = "04d"; // Homework 請分析 json 取出 icon 的值
		String icon = jsonObject.getAsJsonArray("weather")
								.get(0).getAsJsonObject()
								.get("icon").getAsString();
		urlPath = "https://openweathermap.org/img/wn/%s@4x.png";
		urlPath = String.format(urlPath, icon);
		
		client = HttpClient.newHttpClient();
		request = HttpRequest.newBuilder()
				.uri(URI.create(urlPath))
				.build();
		
		HttpResponse<byte[]> response2 = client.send(request, HttpResponse.BodyHandlers.ofByteArray());
		byte[] imageData = response2.body();
		
		Path imagePath = Paths.get("src/day26/icon.png");
		Files.write(imagePath, imageData, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
	}

}














