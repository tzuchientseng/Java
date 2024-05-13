package lazykits.statistics;

/**
 * Interface for statistical calculations.
 */
public interface Statistic {
    /**
     * Calculates the average of an array of doubles.
     * @return The average value.
     */
    double mean();

    /**
     * Calculates the variance of an array of doubles using the population formula (divided by n).
     * @return The variance.
     */
    double vari();

    /**
     * Calculates the standard deviation of an array of doubles using the population formula (divided by n).
     * @return The standard deviation.
     */
    double dev();

    /**
     * Calculates the variance of an array of doubles using the sample formula (divided by n-1).
     * This method provides an unbiased estimator of the population variance when the data is a sample.
     * @return The sample variance.
     */
    double sampVari();

    /**
     * Calculates the standard deviation of an array of doubles using the sample formula (divided by n-1).
     * This method provides an unbiased estimator of the population standard deviation when the data is a sample.
     * @return The sample standard deviation.
     */
    double sampDev();
}
