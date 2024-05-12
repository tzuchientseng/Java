package lazykits.discreteness;

/**
 * Provides static methods to compute combinations and related factorial calculations.
 * <p>
 * This class includes methods to calculate the number of ways to choose k elements from a set of n elements
 * without regard to the order of selection (combinations), and to compute factorials, which are essential
 * to the calculation of combinations.
 */
public class Combination {

    /**
     * Calculates the number of combinations of n items taken k at a time.
     *
     * @param n Total number of items.
     * @param k Number of items to be selected.
     * @return The number of combinations of n items taken k at a time.
     */
    public static long calculate(int n, int k) {
        if (k > n) {
            return 0;
        }
        return factorial(n) / (factorial(k) * factorial(n - k));
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
