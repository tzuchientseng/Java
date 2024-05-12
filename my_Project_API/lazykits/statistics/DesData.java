package lazykits.statistics;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Class for calculating descriptive statistics. This class provides methods to compute
 * mean, variance, standard deviation, median, and mode of a dataset. It also allows calculating
 * the confidence interval for the mean based on the z-score or t-score depending on the sample size.
 */
public class DesData implements Statistic {
    private double[] data;
    /**
     * Constructors
     */
    public DesData() {
    }
    /**
     * Constructs a DescriptiveStatistics object with the given data.
     * @param data Array of doubles for statistical analysis.
     */
    public DesData(double[] data) {
        this.data = data;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double mean() {
        double sum = 0;
        for (double d : data) {
            sum += d;
        }
        return sum / data.length;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double vari() {
        double avg = mean();
        double sum = 0;
        for (double d : data) {
            sum += (d - avg) * (d - avg);
        }
        return sum / data.length;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double dev() {
        return Math.sqrt(vari());
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public double sampVari() {
        double avg = mean();
        double sum = 0;
        for (double d : data) {
            sum += (d - avg) * (d - avg);
        }
        return sum / (data.length - 1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double sampDev() {
        return Math.sqrt(sampVari());
    }

    /**
     * Calculates the median of the data.
     * @return The median value.
     */
    public double median() {
        double[] sortedData = data.clone();
        Arrays.sort(sortedData);
        int midIndex = sortedData.length / 2;
        if (sortedData.length % 2 == 0) {
            return (sortedData[midIndex - 1] + sortedData[midIndex]) / 2.0;
        } else {
            return sortedData[midIndex];
        }
    }

    /**
     * Calculates the mode of the data.
     * @return The mode value. Returns Double.NaN if there's no unique mode.
     */
    public double mode() {
        Map<Double, Integer> frequencyMap = new HashMap<>();
        for (double num : data) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        int maxFreq = 0;
        double mode = Double.NaN;
        boolean multipleModes = false;

        for (Map.Entry<Double, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > maxFreq) {
                mode = entry.getKey();
                maxFreq = entry.getValue();
                multipleModes = false;
            } else if (entry.getValue() == maxFreq) {
                multipleModes = true;
            }
        }
        return multipleModes ? Double.NaN : mode;
    }
  
    /**
     * "\u03BC estimate": (\u03C3 unknown)
     * Calculates the lower bound of the confidence interval for the mean when the population standard deviation is unknown.
     * This method uses the t-distribution for small sample sizes (n &le; 30) and the z-distribution for larger sample sizes.
     * The choice of distribution depends on the assumption that the sample mean approximates the population mean.
     *
     * @param confidenceLevel The desired confidence level as a percentage (e.g., 95 for 95%). Must be between 0 and 100, exclusive.
     *                        Determines how confident one is that the true parameter lies within the calculated interval.
     * @return The lower bound of the confidence interval for the mean.
     * @throws IllegalArgumentException if confidenceLevel is not within the valid range or if the data array is empty.
     *                                  Valid range for confidenceLevel is between 0 and 100, exclusive.
     */
    public double MLbound(double confidenceLevel) {   
        double avg = mean();
        double stdDev = sampDev();
        double n = data.length;

        if (n > 30) {
            double z = StatTables.getZValue(confidenceLevel);
            return avg - (z * (stdDev / Math.sqrt(n)));
        } else {
            int sampleSize = (int) n;
            double t = StatTables.getTValue(confidenceLevel, sampleSize - 1);
            return avg - (t * (stdDev / Math.sqrt(n)));
        }
    }
    
    /**     
     * "\u03BC estimate": (\u03C3 known)
     * Calculates the lower bound of the confidence interval for the mean when the population standard deviation is known.
     * This method uses the z-distribution regardless of sample size.
     *
     * @param confidenceLevel The desired confidence level in percentage.
     * @param sigma The known population standard deviation, must be non-negative.
     * @return The lower bound of the confidence interval.
     * @throws IllegalArgumentException if sigma is negative or confidenceLevel is out of range.
     */
    public double MLbound(double confidenceLevel, double sigma) {   
        double avg = mean();
        double n = data.length;

        if (n > 30) {
            double z = StatTables.getZValue(confidenceLevel);
            return avg - (z * (sigma / Math.sqrt(n)));
        } else {
            int sampleSize = (int) n;
            double t = StatTables.getTValue(confidenceLevel, sampleSize - 1);
            return avg - (t * (sigma / Math.sqrt(n)));
        }
    }

    /**     
    * "\u03BC estimate": 
    * Calculates the lower bound of the confidence interval for the mean when the population standard deviation (sigma) is known.
    * This method uses the z-distribution for large sample sizes (greater than 30) and the t-distribution for smaller sample sizes.
    *
    * @param confidenceLevel The desired confidence level as a percentage (e.g., 95 for 95% confidence).
    * @param sigma The current standard deviation. This parameter must be non-negative.
    * @param mean The sample mean.
    * @param sample The sample size. It determines whether the z-distribution or t-distribution is used.
    * @return The lower bound of the confidence interval for the mean.
    * @throws IllegalArgumentException if sigma is negative, or if the confidence level is not within a sensible range (e.g., 0 to 100).
    */
    public double MLbound(double confidenceLevel, double sigma, double mean, double sample) {   

        if (sample > 30) {
            double z = StatTables.getZValue(confidenceLevel);
            return mean - (z * (sigma / Math.sqrt(sample)));
        } else {
            int sampleSize = (int) sample;
            double t = StatTables.getTValue(confidenceLevel, sampleSize - 1);
            return mean - (t * (sigma / Math.sqrt(sample)));
        }
    }

    /**
     * "\u03BC estimate": (\u03C3 unknown)
     * Calculates the upper bound of the confidence interval for the mean when the population standard deviation is unknown.
     * Applies the same distributional assumptions as for the lower bound.
     *
     * @param confidenceLevel The desired confidence level in percentage.
     * @return The upper bound of the confidence interval.
     * @throws IllegalArgumentException if the data array is empty or confidenceLevel is invalid.
     */
    public double MUbound(double confidenceLevel) {
        double avg = mean();
        double stdDev = sampDev();
        double n = data.length;

        if (n > 30) {
            double z = StatTables.getZValue(confidenceLevel);
            return avg + (z * (stdDev / Math.sqrt(n)));
        } else {
            int sampleSize = (int) n;
            double t = StatTables.getTValue(confidenceLevel, sampleSize - 1);
            return avg + (t * (stdDev / Math.sqrt(n)));
        }
    }
    /**
     * "\u03BC estimate": (\u03C3 known)
     * Calculates the upper bound of the confidence interval for the mean when the population standard deviation is known.
     * This method provides a more precise estimate when sigma is known, using the z-distribution.
     *
     * @param confidenceLevel The desired confidence level in percentage.
     * @param sigma The known population standard deviation, must be non-negative.
     * @return The upper bound of the confidence interval.
     * @throws IllegalArgumentException if sigma is negative or confidenceLevel is invalid.
     */
    public double MUbound(double confidenceLevel, double sigma) {
        double avg = mean();
        double n = data.length;

        if (n > 30) {
            double z = StatTables.getZValue(confidenceLevel);
            return avg + (z * (sigma / Math.sqrt(n)));
        } else {
            int sampleSize = (int) n;
            double t = StatTables.getTValue(confidenceLevel, sampleSize - 1);
            return avg + (t * (sigma / Math.sqrt(n)));
        }
    }

    /**     
    * "\u03BC estimate": 
    * Calculates the upper bound of the confidence interval for the mean when the population standard deviation (sigma) is known.
    * This method uses the z-distribution for large sample sizes (greater than 30) and the t-distribution for smaller sample sizes.
    *
    * @param confidenceLevel The desired confidence level as a percentage (e.g., 95 for 95% confidence).
    * @param sigma The current standard deviation. This parameter must be non-negative.
    * @param mean The sample mean.
    * @param sample The sample size. It determines whether the z-distribution or t-distribution is used.
    * @return The upper bound of the confidence interval for the mean.
    * @throws IllegalArgumentException if sigma is negative, or if the confidence level is not within a sensible range (e.g., 0 to 100).
    */
    public double MUbound(double confidenceLevel, double sigma, double mean, double sample) {   

        if (sample > 30) {
            double z = StatTables.getZValue(confidenceLevel);
            return mean + (z * (sigma / Math.sqrt(sample)));
        } else {
            int sampleSize = (int) sample;
            double t = StatTables.getTValue(confidenceLevel, sampleSize - 1);
            return mean + (t * (sigma / Math.sqrt(sample)));
        }
    }

    /**
     * Calculates the confidence interval for a Bernoulli parameter p using the z-score.
     * 
     * @param successes Number of successes in the Bernoulli trials.
     * @param trials Total number of Bernoulli trials.
     * @param confidenceLevel The desired confidence level in percentage (e.g., 95 for 95%).
     * @return A double array containing the lower and upper bounds of the confidence interval.
     */
    public double[] pCI(double confidenceLevel, int successes, int trials) {
        if (trials == 0) {
            throw new IllegalArgumentException("Number of trials must be greater than 0");
        }
        if (successes > trials) {
            throw new IllegalArgumentException("Number of successes cannot exceed number of trials");
        }
        double z = StatTables.getZValue(confidenceLevel);
        double p = successes / (double) trials;
        double marginOfError = z * Math.sqrt((p * (1 - p)) / trials);

        double lowerBound = (p - marginOfError > 0) ? p - marginOfError : 0;  // Ensure lowerBound is not less than 0
        double upperBound = p + marginOfError;

        return new double[]{lowerBound, upperBound};
    }

    /**
     * Calculates the confidence interval for the variance of the population from which the sample was drawn.
     * Assumes the sample variance is an unbiased estimator of the population variance.
     * 
     * @param confidenceLevel The desired confidence level as a percentage (e.g., 95 for 95% CI).
     * @return A double array containing the lower and upper bounds of the confidence interval for the variance.
     * @throws IllegalArgumentException if sampleSize is less than 2, which is insufficient for variance estimation.
     */
    public double[] varCI(double confidenceLevel) {
        double variance = sampVari();
        int sampleSize = data.length;
        if (sampleSize < 2) {
            throw new IllegalArgumentException("Sample size must be greater than 1 for variance estimation.");
        }
        double rChiValue = StatTables.getRChiValue(confidenceLevel, sampleSize - 1);
        double lChiValue = StatTables.getLChiValue(confidenceLevel, sampleSize - 1);
        double lowerBound = (sampleSize - 1) * variance / rChiValue;  
        double upperBound = (sampleSize - 1) * variance / lChiValue;  
        return new double[]{lowerBound, upperBound};
    }

    /**
     * Calculates the confidence interval for the variance of the population from which the sample was drawn.
     * Assumes the sample variance is an unbiased estimator of the population variance.
     * 
     * @param confidenceLevel The desired confidence level as a percentage (e.g., 95 for 95% CI).
     * @param variance        The sample variance.
     * @param sampleSize      The size of the sample.
     * @return A double array containing the lower and upper bounds of the confidence interval for the variance.
     * @throws IllegalArgumentException if sampleSize is less than 2, which is insufficient for variance estimation.
     */
    public double[] varCI(double confidenceLevel, double variance, int sampleSize) {
        if (sampleSize < 2) {
            throw new IllegalArgumentException("Sample size must be greater than 1 for variance estimation.");
        }
        double rChiValue = StatTables.getRChiValue(confidenceLevel, sampleSize - 1);
        double lChiValue = StatTables.getLChiValue(confidenceLevel, sampleSize - 1);
        double lowerBound = (sampleSize - 1) * variance / rChiValue;  
        double upperBound = (sampleSize - 1) * variance / lChiValue;  
        return new double[]{lowerBound, upperBound};
    }
    
}
