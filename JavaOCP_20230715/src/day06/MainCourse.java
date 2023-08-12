package day06;

public class MainCourse extends Food {
	
	private String cookingMethod;

	public String getCookingMethod() {
		return cookingMethod;
	}

	public void setCookingMethod(String cookingMethod) {
		this.cookingMethod = cookingMethod;
	}

	@Override
	public String toString() {
		return "MainCourse [cookingMethod=" + cookingMethod + ", toString()=" + super.toString() + "]";
	}

	
}
