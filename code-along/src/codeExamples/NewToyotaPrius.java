package codeExamples;

public class NewToyotaPrius implements ToyotaPrius{
	private String colour;
	
	NewToyotaPrius(String colour){
		this.colour = colour;
	}
	
	public String getColour() {
		return colour;
	}
	
	public void setColour(String newColour) {
		this.colour = newColour;
	}
	
	public int getNumWheels() {
		return NUM_WHEELS;
	}
	

}
