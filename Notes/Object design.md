### Main method
* In order for a class to be run, it needs a main method
* Java will begin the execution with the first line of the main method
* The keyword 'static' means that the method is defined for the class, not for the objects in the class
```java
public class MyClass{
	public static void main(String args[]){
	}
}
```

### Class: Basics
* A **class** is a type of data, whereas an object is a piece (instance) of that data
* A good analogy will be comparing classes to factories and objects to the products produced by the factories
* Each object can be customised without affecting other objects that belong to the same class
* **Member Variables**: Variables that exist throughout the class (Declared outside each method but within the definition of the class)
* **Constructor**:  The method that gets called when an object is created. (Note: it doesn't have a return type)
* **this**: "this" refers to the calling object. Therefore, if you print car1.year, for example, it will return blue.

### Method overloading
* An example of polymorphism (poly: many, morph: form)
* It allows you to create multiple versions of a method that do slightly different thing
* They must have different parameter list, due to java's compilation process.
* An example will be default constructor vs parameter constructor. If no arguments are passed to an object's constructor, then the default constructor is used. The parameter constructor is used otherwise.

### Code example 1
```java
// Car.java
public class Car {
// 	Member variables
	private String colour;
	private int year;
	
//	Default constructor
	public Car() {
		this.year = 2023;
		this.colour = "White";
	}

//	Parameter constructor
	public Car(String colour, int year) {
		this.year = year;
		this.colour = colour;

// Method that prints out the specification of the car
	public void getSpec() {
		System.out.println("Year: " + this.year + "  Colour: " + this.colour );
	}
}

// Test.java
public class Test {
	public static void main(String args[]) {
		Car car1 = new Car("blue", 1998);
		Car car2 = new Car("black", 2014);
		car1.getSpec();
		car2.getSpec();
	}
}
// output: 
//Year: 1998 Colour: blue
//Year: 2014 Colour: black
```