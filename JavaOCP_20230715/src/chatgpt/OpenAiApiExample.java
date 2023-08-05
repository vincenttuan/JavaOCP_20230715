package chatgpt;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

/*
curl https://api.openai.com/v1/completions \
  -H 'Content-Type: application/json' \
  -H 'Authorization: Bearer YOUR_TOKEN' \
  -d '{
  "model": "text-davinci-003",
  "prompt": "請問台灣與中國會開戰嗎",
  "max_tokens": 100,
  "temperature": 0,
  "n": 1
}'
max_tokens：用於指定要生成的最大標記數。標記是一個基本的文本單位，通常是一個單詞，但也可以是一個標點符號。
當 OpenAI 接收到一個 prompt（提示）後，使用模型生成的文本的標記數不得超過此值。如果超過此值，則模型將停止生成文本。
temperature：用於控制生成文本的創意程度。溫度越高，生成的文本就越無序和創新，而溫度越低，生成的文本就越可預測和保守。
溫度是一個在0到1之間的浮點數，通常設置在0.5到1之間。
* */
public class OpenAiApiExample {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("請輸入要問的事情：");
        String prompt = scanner.nextLine();
        System.out.print("請輸入創意程度(0(保守/實際)~1(創新/無序)：");
        double temperature = scanner.nextDouble();
    	  String apiKey = "YOUR_TOKEN";
        String apiUrl = "https://api.openai.com/v1/completions";

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + apiKey)
                .POST(HttpRequest.BodyPublishers.ofString(
                        "{\n" +
                        "  \"model\": \"text-davinci-003\",\n" +
                        "  \"prompt\": \"" + prompt + "\",\n" +
                        "  \"max_tokens\": 500,\n" +
                        "  \"temperature\": " + temperature + "\n" +
                        "}"))
                .build();

        HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());
        String jsonString = response.body();
        System.out.println(jsonString);
        
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(jsonString, JsonObject.class);
        
        String text = jsonObject.getAsJsonArray("choices")
                                .get(0).getAsJsonObject()
                                .get("text").getAsString();
        
        int totalTokens = jsonObject.getAsJsonObject("usage")
                                    .get("total_tokens").getAsInt();
        
        System.out.println("Text: " + text.replace("?", "").replace("\n", "").trim());
        System.out.println("Total Tokens: " + totalTokens);
    }
}