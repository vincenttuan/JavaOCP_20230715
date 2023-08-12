package day06;

public class SideDish extends Food {
	private boolean containSugar;

	public boolean isContainSugar() {
		return containSugar;
	}

	public void setContainSugar(boolean containSugar) {
		this.containSugar = containSugar;
	}

	@Override
	public String toString() {
		return "SideDish [containSugar=" + containSugar + ", toString()=" + super.toString() + "]";
	}
	
}
