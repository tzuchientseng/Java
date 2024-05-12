package DesignPattern;
import java.util.ArrayList;

public class CollectionDemo {
    public static void main(String[] args) {
        // Generics determinate boxing type
        ArrayList<Animal> arrayAnimal = new ArrayList<>();
        arrayAnimal.add(new Cat("catName"));
        arrayAnimal.add(new Dog("dogName"));
        arrayAnimal.add(new Dog("dogName2"));
        arrayAnimal.add(new Cat("catName2"));
        arrayAnimal.add(new Cat("catName3"));
        
        // Remove by index(or objectName) (python: ob.remove(element))
        arrayAnimal.remove(4);
        // Remove the Animal with the name "catName2"
        String o = "catName2";
        arrayAnimal.removeIf(animal -> animal.getName().equals(o));

        for(Object item : arrayAnimal) {
            Animal animal = (Animal)item;
            System.out.println(animal.shout());
        }

        System.out.println("The number of animal(ArrayList_Object.size()): " + arrayAnimal.size());  
        arrayAnimal.forEach(animal -> System.out.println(animal.getName())); //forEach is Iterable interface default method
    }
}

/*
For the "One launch single files"
 */
abstract class Animal {
    protected String name;
    protected int shoutNum;

    public Animal() {
        this.name = "";
        this.shoutNum = 1; // Default shoutNum
    }

    public Animal(String name) {
        this.name = name;
        this.shoutNum = 1;
    }

    public String shout() {
        return "";
    }

    public String getName() {
        return this.name;
    }
}

class Cat extends Animal {
    public Cat() {
        super();
    }

    public Cat(String name) {
        super(name);
    }

    @Override
    public String shout() {
        String result = "";
        for (int i = 0; i < this.shoutNum; i++) {
            result += "Meow";
        }
        return "My name is " + name + " " + result;
    }
}

class Dog extends Animal {
    public Dog() {
        super();
    }

    public Dog(String name) {
        super(name);
    }

    @Override
    public String shout() {
        String result = "";
        for (int i = 0; i < this.shoutNum; i++) {
            result += "Wow";
        }
        return "My name is " + name + " " + result;
    }
}

interface IChange {
    String changeThing(String thing);
}

class MachineCat extends Cat implements IChange {
    public MachineCat() {
        super();
    }

    public MachineCat(String name) {
        super(name);
    }

    @Override
    public String changeThing(String thing) {
        return "Changing " + thing;
    }
}

class StoneMonkey extends Animal implements IChange {
    public StoneMonkey() {
        super();
    }

    public StoneMonkey(String name) {
        super(name);
    }

    @Override
    public String changeThing(String thing) {
        return "Transforming " + thing;
    }

    @Override
    public String shout() {
        String result = "";
        for (int i = 0; i < this.shoutNum; i++) {
            result += "Woof";
        }
        return "My name is " + name + " " + result;
    }
}

