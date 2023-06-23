package code_along;

public class Car {
// 	Member variables
	private String colour;
	private int year;
	
//	Constructor
	public Car() {
		this.year = 2023;
		this.colour = "White";
	}
	
	public Car(String colour, int year) {
		this.year = year;
		this.colour = colour;
	}
	
	public void getSpec() {
		System.out.println("Year: " + this.year + "  Coulour: " + this.colour );
	}
}

