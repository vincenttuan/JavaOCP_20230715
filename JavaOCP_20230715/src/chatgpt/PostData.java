package chatgpt;

public class PostData {
	private String model;
	private String prompt;
	private int max_tokens;
	private double temperature;
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getPrompt() {
		return prompt;
	}
	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}
	public int getMax_tokens() {
		return max_tokens;
	}
	public void setMax_tokens(int max_tokens) {
		this.max_tokens = max_tokens;
	}
	public double getTemperature() {
		return temperature;
	}
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
	
	
	
	
}
