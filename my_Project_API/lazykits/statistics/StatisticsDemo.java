package lazykits.statistics;

/**
 * Demonstrates the use of the lazykits.statistics package for performing
 * both descriptive and inferential statistics. This class provides a simple
 * demonstration on how to calculate various statistical measurements such as
 * average, variance, standard deviation, as well as confidence intervals.
 */
public class StatisticsDemo {

    /**
     * The main method that executes the demonstrations of statistical calculations.
     * It initializes an array of doubles and uses it to demonstrate both
     * descriptive and inferential statistics functionalities.
     *
     * @param args not used in this demo
     */
    public static void main(String[] args) {
        // Specify the desired confidence level for descriptive statistics
        double confidenceLevel = 90; // e.g., 95 for 95% confidence level

        // Initialize the data
        double[] data = {148, 155, 126, 117, 124, 136, 141, 133, 129, 146};
        // Create an instance of DescriptiveStatistics with the data
        DesData descriptiveStats = new DesData(data);
        System.out.println("Average: " + descriptiveStats.mean());
        System.out.println("Variance: " + descriptiveStats.vari());
        System.out.println("Standard Deviation: " + descriptiveStats.dev());
        System.out.println("Median: " + descriptiveStats.median());
        System.out.println("Mode: " + descriptiveStats.mode());
        System.out.println("\nVariance (sample formula): " + descriptiveStats.sampVari());
        System.out.println("Standard Deviation (sample formula): " + descriptiveStats.sampDev());

        System.out.println("-----------------Descriptive Statistics (Estimate \u03BC)-----------------");
        // Estimate Mean (Sigma unknown)
        System.out.println("The mean (\u03BC) estimate (\u03C3 unknown) " 
                            + confidenceLevel + "% Confidence Interval: [" 
                            + descriptiveStats.MLbound(confidenceLevel) + ", " 
                            + descriptiveStats.MUbound(confidenceLevel) + "]");
        // Estimate Mean (Sigma known)
        double sigma = 11.27;
        System.out.println("The mean (\u03BC) estimate (\u03C3 known) " 
                            + confidenceLevel + "% Confidence Interval: [" 
                            + descriptiveStats.MLbound(confidenceLevel, sigma) + ", " 
                            + descriptiveStats.MUbound(confidenceLevel, sigma) + "]");

        System.out.println("\n-----------------Descriptive Statistics (Estimate p)-----------------");
        // Example data for Bernoulli trials
        int successes = 6;
        int trials = 150;
        confidenceLevel = 99.0; 
        
        try {
            // Assuming descriptiveStats.pCI() returns a double array with the lower and upper bounds of the confidence interval
            double[] interval = descriptiveStats.pCI(confidenceLevel, successes, trials);
        
            // Print the confidence interval using the actual `confidenceLevel`
            System.out.printf("%.1f%% confidence interval for Bernoulli parameter p: [%.3f, %.3f]%n", confidenceLevel, interval[0], interval[1]);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("\n-----------------Descriptive Statistics (Estimate Sigma)-----------------");
        confidenceLevel = 98; // e.g., 95 for 95% confidence level
        double[] data2 = {113, 106, 102, 104, 112, 115, 103, 109};
        DesData descriptiveStats2 = new DesData(data2);
        try {
            double[] ci = descriptiveStats2.varCI(confidenceLevel);
            System.out.println("95% Confidence Interval for Variance: [" + ci[0] + ", " + ci[1] + "]");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n-----------------InferentialStatistics-----------------");
        // Create an instance of InferentialStatistics with the data
        // InferData inferentialStats = new InferData(data);
    }
}
