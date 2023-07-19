package codeExamplesSuperThis;

public class Main {
	public static void main(String[] args) {
		Student joanna = new Student("Joanna", false);
		Student rajesh = new Student("Rajesh");

		System.out.println(joanna.getEnrollmentStatus());
		// Prints "Joanna: false"
		System.out.println(rajesh.getEnrollmentStatus());
		// Prints "Rajesh: true"
	}

}
