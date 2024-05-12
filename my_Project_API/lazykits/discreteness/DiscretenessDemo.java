package lazykits.discreteness;

/**
 * Demonstrates the use of combinatorial calculations such as permutations, combinations, 
 * and homogeneous combinations.
 * <p>
 * This class provides a main method which calculates and prints results of permutation, 
 * combination, and homogeneous combination for given values of n and k.
 */
public class DiscretenessDemo {

    /**
     * Main method to demonstrate the use of combinatorial functions.
     * 
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        int n = 5; // Total number of items
        int k = 3; // Number of items to choose

        // Calculate and print the permutation of n and k
        System.out.println("P(" + n + ", " + k + ") = " + Permutation.calculate(n, k));
        // Calculate and print the combination of n and k
        System.out.println("C(" + n + ", " + k + ") = " + Combination.calculate(n, k));
        // Calculate and print the homogeneous combination of n and k
        System.out.println("H(" + n + ", " + k + ") = " + HomogeneousCombination.calculate(n, k));
    }
}
