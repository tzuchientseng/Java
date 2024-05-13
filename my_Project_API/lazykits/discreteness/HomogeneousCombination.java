package lazykits.discreteness;

/**
 * Provides methods to calculate homogeneous combinations, where selection of items is done with replacement.
 * <p>
 * This class simplifies the process of determining the number of ways to choose k elements from a set of n types of items,
 * with repetition allowed. It leverages the combination formula to compute results for combinations with repetitions.
 */
public class HomogeneousCombination {

    /**
     * Calculates the number of homogeneous combinations of n items taken k at a time with repetition.
     *
     * @param n Total number of item types.
     * @param k Number of items to be selected, with repetition allowed.
     * @return The number of homogeneous combinations of n items taken k at a time.
     */
    public static long calculate(int n, int k) {
        return Combination.calculate(n + k - 1, k);
    }

    // The commented out factorial method is not needed here since it's handled in the Combination class.
}
