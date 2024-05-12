package animalClassPolymorphism;

public class Main{
	public static void main(String[] args){
		Animal x = new Dog();
   	 	x.eat();
		x.sleep();
 		//x can't barking.
	}
}

class Animal{
	private String name;
	
	public void eat(){
   		System.out.println("The animal is eating.");
	}
	public void sleep(){
		System.out.println("The animal is sleeping.");
	}
}

class Dog extends Animal{
	public void bark(){
		System.out.println("The dog is barking.");
	}
}