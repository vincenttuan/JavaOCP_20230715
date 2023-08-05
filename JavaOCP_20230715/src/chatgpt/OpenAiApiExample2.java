package chatgpt;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class OpenAiApiExample2 {
    public static void main(String[] args) throws IOException, InterruptedException {
    	Path path = Paths.get("src/chatgpt/exam.txt");
    	String prompt = Files.readString(path) + "\n請幫我計算每題的總分與平均";
    	System.out.println(prompt);
    	
    	/*
        double temperature = 0.0;
    	String apiKey = "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";
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
        */
    }
}