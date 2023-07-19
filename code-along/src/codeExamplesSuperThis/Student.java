package codeExamplesSuperThis;

public class Student extends Person {
	private boolean enrolled;
	
	Student(String name){
		this(name, true);
	}
	
	
	Student(String name, boolean enrolled){
		super(name);
		this.enrolled = enrolled;
	}
	
	public String getEnrollmentStatus() {
		  return super.getName() + ": " + enrolled;

	 }
}



