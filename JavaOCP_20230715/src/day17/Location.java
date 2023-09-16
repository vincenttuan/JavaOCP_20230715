package day17;

public class Location {
	private String city;
	private String branch;
	
	public Location(String city, String branch) {
		this.city = city;
		this.branch = branch;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	@Override
	public String toString() {
		return "Location [city=" + city + ", branch=" + branch + "]";
	}
	
}
