package src.lazykits.statistics;

public class InferTwoData extends InferData implements Statistic {
    private double[] data1;
    private double[] data2;

    public InferTwoData(double[] data1, double[] data2) {
        this.data1 = data1;
        this.data2 = data2;
        // initializeZTable(); // Initialize the z-table
        // initializeTTable(); // Initialize the t-table
    }
        /**
     * Calculates the average of the data.
     *
     * @return The average of the data.
     */
    @Override
    public double mean() {
        double sum = 0;
        for (double d : data1) {
            sum += d;
        }
        return sum / data1.length;
    }

    /**
     * Calculates the variance of the data.
     *
     * @return The variance of the data.
     */
    @Override
    public double vari() {
        double avg = mean();
        double sum = 0;
        for (double d : data1) {
            sum += (d - avg) * (d - avg);
        }
        return sum / data1.length;
    }

    /**
     * Calculates the standard deviation of the data.
     *
     * @return The standard deviation of the data.
     */
    @Override
    public double dev() {
        return Math.sqrt(vari());
    }

    /**
     * Retrieves the t-value from the t-table based on the given confidence level and sample size.
     *
     * @param confidenceLevel The desired confidence level.
     * @param n               The sample size.
     * @return The corresponding t-value.
     */
}
