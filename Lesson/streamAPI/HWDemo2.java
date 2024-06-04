package streamAPI;

import java.util.List;

public class HWDemo2 {
    public static void main(String[] args) {
        var list = List.of(
            new Disc(1, "aa", 100, List.of(1, 2, 3)),
            new Disc(2, "bb", 300, List.of(2, 2, 3)),
            new Disc(3, "cc", 500, List.of(3, 5, 4)),
            new Disc(4, "dd", 600, List.of(4, 4, 4)),
            new Disc(5, "ee", 900, List.of(1, 2, 3))
        );
        
        System.out.println(list); // Print the list of Disc objects
        
        // Calculate the sum of all integers in the 'rep' lists of each Disc
        var sum = list.stream()
            .peek(System.out::println)
            .flatMap(d -> d.rep().stream()) // Flatten the lists of integers
            .reduce(0, Integer::sum); // Sum up all the integers
        System.out.println("Sum: " + sum); // Print the sum
    }
}

// Definition of the Disc record
record Disc(int id, String name, int price, List<Integer> rep) {}

