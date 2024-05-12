public class Main{
	public static void main(String[] args){
		Animal a = new Cat();
		a.makeSound();
		a = new Dog();
		a.makeSound();
	}
}

interface Animal{
	public void makeSound();
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