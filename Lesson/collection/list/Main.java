package collection.list;

import java.util.*;

public class Main {
    public static void main(String[] args){
        // Main<Integer> f = new Main<>(); //泛型架構
        List<String> animals = new ArrayList<String>();
        animals.add("Dog");
        animals.add("Cat");
        animals.add("Bird");
        animals.add("Elephant");
// iterator
        Iterator<String> it = animals.iterator();
        while(it.hasNext()){
            String animal = it.next();
            System.out.println(animal);
        }
        System.out.println("=================");
//Enhance for loop
        for(var i: animals){
            System.out.println(i);
        }
    }
}