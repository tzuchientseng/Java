package collection.list;

import java.util.ArrayList;
import java.util.List;

public class array {
    public static void main(String[] args){
        List<String> animals = new ArrayList<String>();
        animals.add("Dog");
        animals.add("Cat");
        animals.add("Bird");
        animals.add("Elephant");
        System.out.println(animals.get(0));
        System.out.println(animals.get(1));
        System.out.println(animals.get(2));
        System.out.println(animals.get(3));
    }
}
