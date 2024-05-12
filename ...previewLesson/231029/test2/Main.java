public class Main{
	public static void main(String[] args){
		makeSound(new Cat());
		makeSound(new Dog());
	}
	private static void makeSound(Animal a ){
		a.makeSound();	
	}
}

interface Animal{
	public abstract void makeSound();
}

class Cat implements Animal {
@Override 
	public void makeSound(){
		System.out.println("Cat meows~");
	}
}


class Dog implements Animal {
@Override 
	public void makeSound(){
		System.out.println("Dog meows~");
	}
}