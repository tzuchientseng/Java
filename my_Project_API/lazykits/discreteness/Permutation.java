package lazykits.discreteness;

/**
 * Provides methods to compute permutations of a set of items.
 * <p>
 * This class facilitates calculating the number of ways to arrange k elements from a set of n elements
 * where the order of arrangement matters. It also includes a utility to compute factorials, essential for permutation calculations.
 */
public class Permutation {

    /**
     * Calculates the number of permutations of n items taken k at a time.
     *
     * @param n Total number of items.
     * @param k Number of items to arrange.
     * @return The number of k-permutations of n items.
     */
    public static long calculate(int n, int k) {
        if (k > n) {
            return 0;
        }
        return factorial(n) / factorial(n - k);
    }

    /**
     * Calculates the factorial of a given number.
     *
     * @param number The number to calculate the factorial of.
     * @return The factorial of the given number.
     */
    private static long factorial(int number) {
        long result = 1;
        for (int factor = 2; factor <= number; factor++) {
            result *= factor;
        }
        return result;
    }
}
