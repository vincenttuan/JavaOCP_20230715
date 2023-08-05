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
    	Path path = Paths.get("src/chatgpt/exam4.txt");
    	//Path path = Paths.get("src/chatgpt/subject.txt");
    	String prompt = Files.readString(path);
    	
    	PostData postData = new PostData();
    	postData.setModel("text-davinci-003");
    	postData.setPrompt(prompt);
    	postData.setMax_tokens(2000);
    	postData.setTemperature(0);
    	
    	// 透過 Gson 將 postData 轉 json 字串
    	Gson gson = new Gson();
    	String postJsonString = gson.toJson(postData);
    	//System.out.println(postJsonString);
    	
    	
        String apiKey = "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";
        String apiUrl = "https://api.openai.com/v1/completions";

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + apiKey)
                .POST(HttpRequest.BodyPublishers.ofString(postJsonString))
                .build();

        HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());
        String jsonString = response.body();
        System.out.println(jsonString);
        
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