package code_along;

public class Car {
// 	Member variables
	private String colour;
	private int year;
	
//	Default constructor
	public Car() {
		this.year = 2023;
		this.colour = "White";
	}
	
// Parameter constructor
	public Car(String colour, int year) {
		this.year = year;
		this.colour = colour;
	}
	
// Getters
	public int getYear() {
		return this.year;
	}
	
// Setters 
	public void setYear(int newYear) {
		if (1885 <= newYear) {
			this.year = newYear;
		}
		else {
			System.out.println("Car has not been invented yet you dum");
		}
	}
	
	public void printSpec() {
		System.out.println("Year: " + this.year + "  Coulour: " + this.colour );
	}
}

