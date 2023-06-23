package code_along;

public class Test {
	public static void main(String args[]) {
		Car car1 = new Car("blue", 1998);
		Car car2 = new Car("black", 2014);
		car1.printSpec();
		car2.printSpec();
		car1.setYear(0);
		System.out.println(car1.getYear());
		car1.setYear(2012);
		System.out.println(car1.getYear());
	}

}