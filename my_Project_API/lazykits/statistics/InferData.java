package lazykits.statistics;

import java.util.HashMap;

/**
 * Class for calculating inferential statistics.
 */
public class InferData implements Statistic {
    private double[] data;
    private HashMap<Double, Double> zTable; // HashMap for storing z-values corresponding to confidence levels
    private HashMap<Integer, HashMap<Double, Double>> tTable; // HashMap for storing t-values corresponding to confidence levels and sample sizes

    // T-table values for different confidence levels and sample sizes
    private float[] eighty = {3.078f, 1.886f, 1.638f, 1.533f, 1.476f, 1.440f, 1.415f, 1.397f, 1.383f, 1.372f, 1.363f, 1.356f, 1.350f, 1.345f, 1.341f, 1.337f, 1.333f,
            1.330f, 1.328f, 1.325f, 1.323f, 1.321f, 1.319f, 1.318f, 1.316f, 1.315f, 1.314f, 1.313f, 1.311f, 1.310f, 1.303f, 1.296f, 1.289f, 1.282f};
    private float[] ninety = {6.314f, 2.920f, 2.353f, 2.132f, 2.015f, 1.943f, 1.895f, 1.860f, 1.833f, 1.812f, 1.796f, 1.782f, 1.771f, 1.761f, 1.753f, 1.746f, 1.740f,
            1.734f, 1.729f, 1.725f, 1.721f, 1.717f, 1.714f, 1.711f, 1.708f, 1.706f, 1.703f, 1.701f, 1.699f, 1.697f, 1.684f, 1.671f, 1.685f, 1.645f};
    private float[] ninetyfive = {12.706f, 4.303f, 3.128f, 2.776f, 2.571f, 2.447f, 2.365f, 2.306f, 2.262f, 2.228f, 2.201f, 2.179f, 2.160f, 2.145f, 2.131f, 2.120f, 2.110f,
            2.101f, 2.093f, 2.086f, 2.080f, 2.074f, 2.069f, 2.064f, 2.060f, 2.056f, 2.052f, 2.048f, 2.045f, 2.042f, 2.021f, 2.000f, 1.980f, 1.960f};
    private float[] ninetyeight = {31.821f, 6.965f, 4.541f, 3.747f, 3.365f, 3.143f, 2.998f, 2.896f, 2.821f, 2.764f, 2.718f, 2.681f, 2.650f, 2.624f, 2.602f, 2.583f, 2.567f,
            2.552f, 2.539f, 2.528f, 2.518f, 2.508f, 2.500f, 2.492f, 2.485f, 2.479f, 2.473f, 2.467f, 2.462f, 2.457f, 2.423f, 2.390f, 2.358f, 2.326f};
    private float[] ninetynine = {63.657f, 9.925f, 5.841f, 4.604f, 4.032f, 3.707f, 3.499f, 3.355f, 3.250f, 3.169f, 3.106f, 3.055f, 3.012f, 2.977f, 2.947f, 2.921f, 2.898f,
            2.878f, 2.861f, 2.845f, 2.831f, 2.819f, 2.807f, 2.797f, 2.787f, 2.779f, 2.771f, 2.763f, 2.756f, 2.750f, 2.704f, 2.660f, 2.617f, 2.576f};

    /**
     * Constructs an InferentialStatistics object with the given data.
     *
     * @param data Array of doubles for statistical analysis.
     */
    public InferData(double[] data) {
        this.data = data;
        initializeZTable(); // Initialize the z-table
        initializeTTable(); // Initialize the t-table
    }

    /**
     * Initializes the z-table with commonly used confidence levels and corresponding z-values.
     */
    private void initializeZTable() {
        zTable = new HashMap<>();
        zTable.put(80.0, 1.28);
        zTable.put(85.0, 1.44);
        zTable.put(90.0, 1.645);
        zTable.put(95.0, 1.96);
        zTable.put(98.0, 2.326);
        zTable.put(99.0, 2.576);
    }

    /**
     * Initializes the t-table with t-values corresponding to confidence levels and sample sizes.
     */
    private void initializeTTable() {
        tTable = new HashMap<>();
        // Add t-values for different confidence levels and sample sizes
        // Example:
        // tTable.put(95, new HashMap<>());
        // tTable.get(95).put(10, 2.262);
        // tTable.get(95).put(15, 2.131);
        // tTable.get(95).put(20, 2.086);
        // Add more t-values as needed
    }

    /**
     * Calculates the lower bound of the confidence interval for the mean.
     *
     * @param confidenceLevel The desired confidence level (e.g., 95 for 95% confidence level).
     * @return The lower bound of the confidence interval.
     */
    public double Lbound(double confidenceLevel) {   
        double avg = mean();
        double stdDev = dev();
        double n = data.length;

        if (n > 30) {
            double z = getZValue(confidenceLevel);
            return avg - (z * (stdDev / Math.sqrt(n)));
        } else {
            int sampleSize = (int) n;
            double t = getTValue(confidenceLevel, sampleSize);
            return avg - (t * (stdDev / Math.sqrt(n)));
        }
    }

    /**
     * Calculates the upper bound of the confidence interval for the mean.
     *
     * @param confidenceLevel The desired confidence level (e.g., 95 for 95% confidence level).
     * @return The upper bound of the confidence interval.
     */
    public double Ubound(double confidenceLevel) {
        double avg = mean();
        double stdDev = dev();
        double n = data.length;

        if (n > 30) {
            double z = getZValue(confidenceLevel);
            return avg + (z * (stdDev / Math.sqrt(n)));
        } else {
            int sampleSize = (int) n;
            double t = getTValue(confidenceLevel, sampleSize);
            return avg + (t * (stdDev / Math.sqrt(n)));
        }
    }

    /**
     * Retrieves the z-value from the z-table based on the given confidence level.
     *
     * @param confidenceLevel The desired confidence level.
     * @return The corresponding z-value.
     */
    private double getZValue(double confidenceLevel) {
        if (zTable.containsKey(confidenceLevel)) {
            return zTable.get(confidenceLevel);
        } else {
            // If the confidence level is not in the table, return a default value or handle it accordingly
            // Here, we return 1.96 which corresponds to 95% confidence level
            return 1.96;
        }
    }

    /**
     * Retrieves the t-value from the t-table based on the given confidence level and sample size.
     *
     * @param confidenceLevel The desired confidence level.
     * @param sampleSize      The sample size.
     * @return The corresponding t-value.
     */
    private double getTValue(double confidenceLevel, int sampleSize) {
        if (tTable.containsKey(confidenceLevel) && tTable.get(confidenceLevel).containsKey(sampleSize)) {
            return tTable.get(confidenceLevel).get(sampleSize);
        } else {
            // Handle the case when t-value is not available in the table
            // You can return a default value or throw an exception based on your requirement
            return -1;
        }
    }

    /**
     * Calculates the average of the data.
     *
     * @return The average of the data.
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
     * Calculates the variance of the data.
     *
     * @return The variance of the data.
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
     * Calculates the standard deviation of the data.
     *
     * @return The standard deviation of the data.
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
     * Retrieves the t-value from the t-table based on the given confidence level and sample size.
     *
     * @param confidenceLevel The desired confidence level.
     * @param n               The sample size.
     * @return The corresponding t-value.
     */
    public float Ttable(float confidenceLevel, int n) {
        float value = -1f; // Default value if CI or n is invalid

        if (confidenceLevel == 80) {
            if (n >= 1 && n <= 34)
                value = eighty[n - 1];
        } else if (confidenceLevel == 90) {
            if (n >= 1 && n <= 34)
                value = ninety[n - 1];
        } else if (confidenceLevel == 95) {
            if (n >= 1 && n <= 34)
                value = ninetyfive[n - 1];
        } else if (confidenceLevel == 98) {
            if (n >= 1 && n <= 34)
                value = ninetyeight[n - 1];
        } else if (confidenceLevel == 99) {
            if (n >= 1 && n <= 34)
                value = ninetynine[n - 1];
        }

        return value;
    }
}

