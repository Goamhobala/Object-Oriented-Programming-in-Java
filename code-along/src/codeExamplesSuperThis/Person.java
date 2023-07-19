package codeExamplesSuperThis;

public class Person {
	private String name;
	
	Person(String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	private static void printRandom(){
		System.out.println("Random");
	}
}
