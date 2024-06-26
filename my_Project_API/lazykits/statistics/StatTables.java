package lazykits.statistics;

import java.util.HashMap;

/**
 * StatTables class provides statistical tables for various distribution values including Z, T, Chi-Square, and F distributions.
 * This class supports retrieving specific values given confidence levels and degrees of freedom where applicable.
 */
public class StatTables {
    private static final HashMap<Double, Double> zTable = new HashMap<>();  // HashMap for storing z-values corresponding to confidence levels
    private static final HashMap<Double, HashMap<Integer, Double>> tTable = new HashMap<>(); // HashMap for storing t-values corresponding to confidence levels and sample sizes
    private static final HashMap<Double, HashMap<Integer, Double>> LChiSquare = new HashMap<>(); // HashMap for storing t-values corresponding to confidence levels and sample sizes
    private static final HashMap<Double, HashMap<Integer, Double>> RChiSquare = new HashMap<>(); // HashMap for storing t-values corresponding to confidence levels and sample sizes
    private static final HashMap<Double, HashMap<Integer, HashMap<Integer, Double>>> fValues = new HashMap<>();

  // Static initializer for populating the statistical tables
    static {
        initializeZTable(); // Initialize the z-table
        initializeTTable(); // Initialize the t-table
        initializeLChiSquare();
        initializeRChiSquare();
        initializeFDistribution();
    }

    /**
     * Initializes the Z-value table with common confidence levels.
     */
    private static void initializeZTable() {
        zTable.put(80.0, 1.28);
        zTable.put(85.0, 1.44);
        zTable.put(90.0, 1.644853627);
        zTable.put(95.0, 1.959963985);
        zTable.put(98.0, 2.326347874);
        zTable.put(99.0, 2.575829304);
        zTable.put(99.8, 3.090232306);
        zTable.put(99.9, 3.2905267314);
    }
    /**
     * Initializes the T-value table with values for different confidence levels and sample sizes.
     */
    private static void initializeTTable() {
        putTValues(80.0, new Double[]{3.078d, 1.886d, 1.638d, 1.533d, 1.476d, 1.440d, 1.415d, 1.397d, 1.383d, 1.372d, 1.363d, 1.356d, 1.350d, 1.345d, 1.341d, 1.337d, 1.333d,
                                                 1.330d, 1.328d, 1.325d, 1.323d, 1.321d, 1.319d, 1.318d, 1.316d, 1.315d, 1.314d, 1.313d, 1.311d, 1.310d, 1.303d, 1.296d, 1.289d, 1.282d});
        putTValues(90.0, new Double[]{6.314d, 2.920d, 2.353d, 2.132d, 2.015d, 1.943d, 1.895d, 1.860d, 1.833d, 1.812d, 1.796d, 1.782d, 1.771d, 1.761d, 1.753d, 1.746d, 1.740d,
                                                 1.734d, 1.729d, 1.725d, 1.721d, 1.717d, 1.714d, 1.711d, 1.708d, 1.706d, 1.703d, 1.701d, 1.699d, 1.697d, 1.684d, 1.671d, 1.658d, 1.645d});
        putTValues(95.0, new Double[]{12.706d, 4.303d, 3.182d, 2.776d, 2.571d, 2.447d, 2.365d, 2.306d, 2.262d, 2.228d, 2.201d, 2.179d, 2.160d, 2.145d, 2.131d, 2.120d, 2.110d,
                                                 2.101d, 2.093d, 2.086d, 2.080d, 2.074d, 2.069d, 2.064d, 2.060d, 2.056d, 2.052d, 2.048d, 2.045d, 2.042d, 2.021d, 2.000d, 1.980d, 1.960d});
        putTValues(98.0, new Double[]{31.821d, 6.965d, 4.541d, 3.747d, 3.365d, 3.143d, 2.998d, 2.896d, 2.821d, 2.764d, 2.718d, 2.681d, 2.650d, 2.624d, 2.602d, 2.583d, 2.567d,
                                                 2.552d, 2.539d, 2.528d, 2.518d, 2.508d, 2.500d, 2.492d, 2.485d, 2.479d, 2.473d, 2.467d, 2.462d, 2.457d, 2.423d, 2.390d, 2.358d, 2.326d});
        putTValues(99.0, new Double[]{63.657d, 9.925d, 5.841d, 4.604d, 4.032d, 3.707d, 3.499d, 3.355d, 3.250d, 3.169d, 3.106d, 3.055d, 3.012d, 2.977d, 2.947d, 2.921d, 2.898d,
                                                 2.878d, 2.861d, 2.845d, 2.831d, 2.819d, 2.807d, 2.797d, 2.787d, 2.779d, 2.771d, 2.763d, 2.756d, 2.750d, 2.704d, 2.660d, 2.617d, 2.576d});
    }   
    /**
     * Helper method to populate the T-value table for a specific confidence level.
     * @param confidence The confidence level in percentage.
     * @param values Array of T-values corresponding to incremental sample sizes.
     */
    private static void putTValues(double confidence, Double[] values) {
        HashMap<Integer, Double> map = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            map.put(i + 1, values[i]);
        }
        tTable.put(confidence, map);
    }

    /**
     * Initializes the left chi-square table with values for different confidence levels and degrees of freedom.
     */
    private static void initializeLChiSquare() {
        putLChiSquare(80.0, new Double[]{0.015791, 0.210721, 0.5844, 1.0636, 1.6103, 2.2041, 2.8331, 3.4895, 4.1682, 4.8652, 5.5778, 6.3038, 7.0415, 7.7895, 8.5468,
                                                    9.3122, 10.0852, 10.8649, 11.6509, 12.4426, 13.2396, 14.0415, 14.8480, 15.6587, 16.4734, 17.2919, 18.1139, 18.9392, 19.7677, 20.5992});
        putLChiSquare(90.0, new Double[]{0.003932, 0.0102586, 0.3518, 0.7107, 1.1455, 1.6354, 2.1673, 2.7326, 3.3251, 3.9403, 4.5748, 5.2260, 5.8919, 6.5706, 7.2609,
                                                    7.9616, 8.6718, 9.3904, 10.1170, 10.8508, 11.5913, 12.3380, 13.0905, 13.8484, 14.6114, 15.3792, 16.1514, 16.9279, 17.7084, 18.4927});
        putLChiSquare(95.0, new Double[]{0.000982, 0.050636, 0.2158, 0.4844, 0.8312, 1.2373, 1.6899, 2.1797, 2.7004, 3.2470, 3.8157, 4.4038, 5.0087, 5.6287, 6.2621,
                                                    6.9077, 7.5642, 8.2307, 8.9065, 9.5908, 10.2829, 10.9823, 11.6885, 12.4011, 13.1197, 13.8439, 14.5734, 15.3079, 16.0471, 16.7908});
        putLChiSquare(98.0, new Double[]{0.000157, 0.0201, 0.1148, 0.2971, 0.5543, 0.8721, 1.2390, 1.6465, 2.0879, 2.5582, 3.0535, 3.5706, 4.1069, 4.6604, 5.2294,
                                                    5.8112, 6.4077, 7.0149, 7.6327, 8.2604, 8.8972, 9.5425, 10.1957, 10.8563, 11.5240, 12.1982, 12.8785, 13.5647, 14.2564, 14.9535});
        putLChiSquare(99.0, new Double[]{3.92713E-05 , 0.010025, 0.0717, 0.2070, 0.4118, 0.6757, 0.9893, 1.3444, 1.7349, 2.1558, 2.6032, 3.0738, 3.5650, 4.0747, 4.6009,
                                                    5.1422, 5.6973, 6.2648, 6.8439, 7.4338, 8.0366, 8.6427, 9.2604, 9.8862, 10.5196, 11.1602, 11.8077, 12.4613, 13.1211, 13.7867});
    } 
    /**
     * Helper method to populate the left chi-square table for a specific confidence level.
     * @param confidence The confidence level in percentage.
     * @param values Array of left chi-square values corresponding to incremental degrees of freedom.
     */
    private static void putLChiSquare(double confidence, Double[] values) {
        HashMap<Integer, Double> map = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            map.put(i + 1, values[i]);
        }
        LChiSquare.put(confidence, map);
    }

    /**
     * Initializes the right chi-square table with values for different confidence levels and degrees of freedom.
     */
    private static void initializeRChiSquare() {
        putRChiSquare(80.0, new Double[]{2.71, 4.61, 6.25, 7.78, 9.24, 10.64, 12.02, 13.36, 14.68, 15.99, 17.28, 18.55, 19.81, 21.06, 22.31,
                                                   23.54, 24.77, 25.99, 27.20, 28.41, 29.62, 30.81, 32.01, 33.20, 34.38, 35.56, 36.74, 37.92, 39.09, 40.26});
        putRChiSquare(90.0, new Double[]{3.84, 5.99, 7.81, 9.49, 11.07, 12.59, 14.07, 15.51, 16.92, 18.31, 19.68, 21.03, 22.36, 23.68, 25.00,
                                                   26.30, 27.59, 28.87, 30.14, 31.41, 32.67, 33.92, 35.17, 36.42, 37.65, 38.89, 40.11, 41.34, 42.56, 43.77});
        putRChiSquare(95.0, new Double[]{5.02, 7.38, 9.35, 11.14, 12.83, 14.45, 16.01, 17.53, 19.02, 20.48, 21.92, 23.34, 24.74, 26.12, 27.49,
                                                   28.85, 30.19, 31.53, 32.85, 34.17, 35.48, 36.78, 38.08, 39.36, 40.65, 41.92, 43.19, 44.46, 45.72, 46.98});
        putRChiSquare(98.0, new Double[]{6.63, 9.21, 11.34, 13.28, 15.09, 16.81, 18.48, 20.09, 21.67, 23.21, 24.72, 26.22, 27.69, 29.14, 30.58,
                                                   32.0, 33.41, 34.81, 36.19, 37.57, 38.93, 40.29, 41.64, 42.98, 44.31, 45.64, 46.96, 48.28, 49.59, 50.89});
        putRChiSquare(99.0, new Double[]{7.88, 10.60, 12.84, 14.86, 16.75, 18.55, 20.28, 21.96, 23.59, 25.19, 26.76, 28.30, 29.82, 31.32, 32.80,
                                                   34.27, 35.72, 37.16, 38.58, 40.00, 41.40, 42.80, 44.18, 45.56, 46.93, 48.29, 49.64, 50.99, 52.34, 53.67});
    } 
    /**
     * Helper method to populate the right chi-square table for a specific confidence level.
     * @param confidence The confidence level in percentage.
     * @param values Array of right chi-square values corresponding to incremental degrees of freedom.
     */
    private static void putRChiSquare(double confidence, Double[] values) {
        HashMap<Integer, Double> map = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            map.put(i + 1, values[i]);
        }
        RChiSquare.put(confidence, map);
    }

    /**
     * Initializes the F-distribution table with values for different confidence levels and degrees of freedom.
     */
    private static void initializeFDistribution() {
        putFDistribution(90.0, new Double[][]{  // For 90% CI, new data provided
            {161.45, 18.513, 10.128, 7.7086, 6.6079, 5.9874, 5.5914, 5.3177, 5.1174, 4.9646, 4.8433, 4.7472, 4.6672, 4.6001, 4.5431, 4.4940, 4.4513, 4.4139, 4.3808, 4.3513, 4.3248, 4.3009, 4.2793, 4.2597, 4.2417, 4.2252, 4.2100, 4.1960, 4.1830, 4.1709},
            {199.50, 19.000, 9.5521, 6.9443, 5.7861, 5.1433, 4.7374, 4.4590, 4.2565, 4.1028, 3.9823, 3.8853, 3.8056, 3.7389, 3.6823, 3.6337, 3.5915, 3.5546, 3.5219, 3.4928, 3.4668, 3.4434, 3.4221, 3.4028, 3.3852, 3.3690, 3.3541, 3.3404, 3.3277, 3.3158},
            {215.71, 19.164, 9.2766, 6.5914, 5.4095, 4.7571, 4.3468, 4.0662, 3.8626, 3.7083, 3.5874, 3.4903, 3.4105, 3.3439, 3.2874, 3.2389, 3.1968, 3.1599, 3.1274, 3.0984, 3.0725, 3.0491, 3.0280, 3.0088, 2.9912, 2.9751, 2.9604, 2.9467, 2.9340, 2.9223},
            {224.58, 19.247, 9.1172, 6.3883, 5.1922, 4.5337, 4.1203, 3.8378, 3.6331, 3.4780, 3.3567, 3.2592, 3.1791, 3.1122, 3.0556, 3.0069, 2.9647, 2.9277, 2.8951, 2.8661, 2.8401, 2.8167, 2.7955, 2.7763, 2.7587, 2.7426, 2.7278, 2.7141, 2.7014, 2.6896},
            {230.16, 19.296, 9.0135, 6.2560, 5.0503, 4.3874, 3.9715, 3.6875, 3.4817, 3.3258, 3.2039, 3.1059, 3.0254, 2.9582, 2.9013, 2.8524, 2.8100, 2.7729, 2.7401, 2.7109, 2.6848, 2.6613, 2.6400, 2.6207, 2.6030, 2.5868, 2.5719, 2.5581, 2.5454, 2.5336},
            {233.99, 19.330, 8.9406, 6.1631, 4.9503, 4.2839, 3.8660, 3.5806, 3.3738, 3.2172, 3.0946, 2.9961, 2.9153, 2.8477, 2.7905, 2.7413, 2.6987, 2.6613, 2.6283, 2.5990, 2.5757, 2.5491, 2.5277, 2.5082, 2.4904, 2.4741, 2.4591, 2.4453, 2.4324, 2.4205},
            {236.77, 19.353, 8.8868, 6.0942, 4.8759, 4.2066, 3.7870, 3.5005, 3.2927, 3.1355, 3.0123, 2.9134, 2.8321, 2.7642, 2.7066, 2.6572, 2.6143, 2.5767, 2.5435, 2.5140, 2.4876, 2.4638, 2.4422, 2.4226, 2.4047, 2.3883, 2.3732, 2.3593, 2.3463, 2.3343},
            {238.88, 19.371, 8.8452, 6.0410, 4.8183, 4.1468, 3.7257, 3.4381, 3.2296, 3.0717, 2.9480, 2.8486, 2.7669, 2.6987, 2.6408, 2.5911, 2.5480, 2.5102, 2.4768, 2.4471, 2.4205, 2.3965, 2.3748, 2.3551, 2.3371, 2.3205, 2.3053, 2.2913, 2.2782, 2.2662},
            {240.54, 19.385, 8.8123, 5.9988, 4.7725, 4.0990, 3.6767, 3.3881, 3.1789, 3.0204, 2.8962, 2.7964, 2.7144, 2.6458, 2.5876, 2.5377, 2.4943, 2.4563, 2.4227, 2.3928, 2.3661, 2.3419, 2.3201, 2.3002, 2.2821, 2.2655, 2.2501, 2.2360, 2.2229, 2.2107},
            {241.88, 19.396, 8.7855, 5.9644, 4.7351, 4.0600, 3.6365, 3.3472, 3.1373, 2.9782, 2.8536, 2.7534, 2.6710, 2.6021, 2.5437, 2.4935, 2.4499, 2.4117, 2.3779, 2.3479, 2.3210, 2.2967, 2.2747, 2.2547, 2.2365, 2.2197, 2.2043, 2.1900, 2.1768, 2.1646}
        });
        putFDistribution(95.0, new Double[][]{  // For 95% CI, new data provided
            {647.79, 38.506, 17.443, 12.218, 10.007, 8.8131, 8.0727, 7.5709, 7.2093, 6.9367, 6.7241, 6.5538, 6.4143, 6.2979, 6.1995, 6.1151, 6.0420, 5.9781, 5.9216, 5.8715, 5.8266, 5.7863, 5.7498, 5.7167, 5.6864, 5.6586, 5.6331, 5.6096, 5.5878, 5.5675},
            {799.50, 39.000, 16.044, 10.649, 8.4336, 7.2598, 6.5415, 6.0595, 5.7147, 5.4564, 5.2559, 5.0959, 4.9653, 4.8567, 4.7650, 4.6867, 4.6189, 4.5597, 4.5075, 4.4613, 4.4199, 4.3828, 4.3492, 4.3187, 4.2909, 4.2655, 4.2421, 4.2205, 4.2006, 4.1821},
            {864.16, 39.165, 15.439, 9.9792, 7.7636, 6.5988, 5.8898, 5.4160, 5.0781, 4.8256, 4.6300, 4.4742, 4.3472, 4.2417, 4.1528, 4.0768, 4.0112, 3.9539, 3.9034, 3.8587, 3.8188, 3.7829, 3.7505, 3.7211, 3.6943, 3.6697, 3.6472, 3.6264, 3.6072, 3.5894},
            {899.58, 39.248, 15.101, 9.6045, 7.3879, 6.2272, 5.5226, 5.0526, 4.7181, 4.4638, 4.2751, 4.1212, 3.9959, 3.8919, 3.8043, 3.7294, 3.6648, 3.6083, 3.5587, 3.5147, 3.4754, 3.4401, 3.4083, 3.3794, 3.3530, 3.3289, 3.3067, 3.2863, 3.2674, 3.2499},
            {921.85, 29.298, 14.885, 9.3645, 7.1461, 5.9876, 5.2852, 4.8173, 4.4844, 4.2361, 4.0440, 3.8911, 3.7667, 3.6634, 3.5764, 3.5021, 3.4379, 3.3820, 3.3327, 3.2891, 3.2501, 3.2151, 3.1835, 3.1548, 3.1287, 3.1048, 3.0828, 3.0625, 3.0438, 3.0265},
            {937.11, 39.331, 14.735, 9.1973, 6.9777, 5.8197, 5.1186, 4.6517, 4.3197, 4.0721, 3.8807, 3.7283, 3.6043, 3.5014, 3.4147, 3.3406, 3.2767, 3.2209, 3.1718, 3.1283, 3.0895, 3.0546, 3.0232, 2.9946, 2.9685, 2.9447, 2.9228, 2.9027, 2.8840, 2.8667},
            {948.22, 39.355, 14.624, 9.0741, 6.8531, 5.6955, 4.9949, 4.5286, 4.1971, 3.9498, 3.7586, 3.6065, 3.4827, 3.3799, 3.2934, 3.2194, 3.1556, 3.0999, 3.0509, 3.0074, 2.9686, 2.9338, 2.9024, 2.8738, 2.8478, 2.8420, 2.8021, 2.7820, 2.7633, 2.7460},
            {956.66, 39.373, 14.540, 8.9796, 6.7572, 5.5996, 4.8994, 4.4332, 4.1020, 3.8549, 3.6638, 3.5118, 3.3880, 3.3853, 3.1987, 3.1248, 3.0610, 3.0053, 2.9563, 2.9128, 2.8740, 2.8392, 2.8077, 2.7791, 2.7531, 2.7293, 2.7074, 2.6872, 2.6686, 2.6513},
            {963.28, 39.387, 14.473, 8.9047, 6.6810, 5.5234, 4.8232, 4.3572, 4.0260, 3.7790, 3.5879, 3.4358, 3.3120, 2.2093, 3.1227, 3.0488, 2.9849, 2.9291, 2.8800, 2.8365, 2.7977, 2.7628, 2.7313, 2.7027, 2.6766, 2.6528, 2.6309, 2.6106, 2.5919, 2.5746},
            {968.63, 39.398, 14.419, 8.8439, 6.6192, 5.4613, 4.7611, 4.2951, 3.9639, 3.7168, 3.5257, 3.3736, 3.2497, 3.1469, 3.0602, 2.9862, 2.9222, 2.8664, 2.8173, 2.7737, 2.7348, 2.6998, 2.6682, 2.6396, 2.6135, 2.5895, 2.5676, 2.5473, 2.5286, 2.5112}
        });
        putFDistribution(98.0, new Double[][]{
            {4052.2, 98.503, 34.116, 21.198, 16.258, 13.745, 12.246, 11.259, 10.561, 10.044, 9.6460, 9.3302, 9.0738, 8.8616, 8.6831, 8.5310, 8.3997, 8.2854, 8.1850, 8.0960, 8.0166, 7.9454, 7.8811, 7.8229, 7.7698, 7.7213, 7.6767, 7.6356, 7.5976, 7.5625},
            {4999.5, 99.000, 30.817, 18.000, 13.274, 10.925, 9.5466, 8.6491, 8.0215, 7.5594, 7.2057, 6.9266, 6.7010, 6.5149, 6.3589, 6.2262, 6.1121, 6.0129, 5.9259, 5.8489, 5.7804, 5.7190, 5.6637, 5.6136, 5.5680, 5.5263, 5.4881, 5.4529, 5.4205, 5.3904},
            {5403.3, 99.166, 29.457, 16.694, 12.060, 9.7795, 8.4513, 7.5910, 6.9919, 6.5523, 6.2167, 5.9526, 5.7394, 5.5639, 5.4170, 5.2922, 5.1850, 5.0919, 5.0103, 4.9382, 4.8740, 4.8166, 4.7649, 4.7181, 4.6755, 4.6366, 4.6009, 4.5681, 4.5378, 4.5097},
            {5624.6, 99.249, 28.710, 15.977, 11.392, 9.1483, 7.8467, 7.0060, 6.4221, 5.9943, 5.6683, 5.4119, 5.2053, 5.0354, 4.8932, 4.7726, 4.6690, 4.5790, 4.5003, 4.4307, 4.3688, 4.3134, 4.2635, 4.2184, 4.1774, 4.1400, 4.1056, 4.0740, 4.0449, 4.0179},
            {5763.7, 99.299, 28.237, 15.522, 10.967, 8.7459, 7.4604, 6.6318, 6.0569, 5.6363, 5.3160, 5.0643, 4.8616, 4.6590, 4.5556, 4.4374, 4.3359, 4.2479, 4.1708, 4.1027, 4.0421, 3.9880, 3.9392, 3.8951, 3.8550, 3.8183, 3.7848, 3.7539, 3.7254, 3.6990},
            {5859.0, 99.332, 27.911, 15.207, 10.672, 8.4661, 7.1914, 6.3707, 5.8018, 5.3858, 5.0692, 4.8206, 4.6204, 4.4558, 4.3183, 4.2016, 4.1015, 4.0146, 3.9386, 3.8714, 3.8117, 3.7583, 3.7102, 3.6667, 3.6272, 3.5911, 3.5580, 3.5276, 3.4995, 3.4735},
            {5928.3, 99.356, 27.672, 14.976, 10.456, 8.2600, 6.9928, 6.1776, 5.6129, 5.2001, 4.8861, 4.6395, 4.4410, 4.2779, 4.1415, 4.0259, 3.9267, 3.8406, 3.7653, 3.6987, 3.6396, 3.5867, 3.5390, 3.4959, 3.4568, 3.4210, 3.3882, 3.3581, 3.3302, 3.3045},
            {5981.6, 99.347, 27.489, 14.799, 10.289, 8.1016, 6.8401, 6.0289, 5.4671, 5.0567, 4.7445, 4.4994, 4.3021, 4.1399, 4.0045, 3.8896, 3.7910, 3.7054, 3.6305, 3.5644, 3.5056, 3.4530, 3.4057, 3.3629, 3.3239, 3.2884, 3.2558, 3.2259, 3.1982, 3.1726},
            {6022.3, 99.388, 27.345, 14.659, 10.158, 7.9761, 6.7188, 5.9106, 5.3511, 4.9424, 4.6315, 4.3875, 4.1911, 4.0297, 3.8948, 3.7804, 3.6822, 3.5971, 3.5225, 3.4567, 3.3981, 3.3458, 3.2986, 3.2560, 3.2172, 3.1818, 3.1494, 3.1195, 3.0920, 3.0665},
            {6055.8, 99.399, 27.229, 14.546, 10.051, 7.8741, 6.6201, 5.8143, 5.2565, 4.8492, 4.5393, 4.2961, 4.1003, 3.9394, 3.8049, 3.6909, 3.5931, 3.5082, 3.4338, 3.3682, 3.3098, 3.2576, 3.2106, 3.1681, 3.1294, 3.0941, 3.0618, 3.0320, 3.0045, 2.9791}
        });
        putFDistribution(99.0, new Double[][]{
            {16211.0, 198.50, 55.552, 31.333, 22.785, 18.635, 16.236, 14.688, 13.614, 12.826, 12.226, 11.754, 11.374, 11.060, 10.798, 10.575, 10.384, 10.218, 10.073, 9.9439, 9.8295, 9.7271, 9.6348, 9.5513, 9.4753, 9.4059, 9.3423, 9.2838, 9.2297, 9.1797},
            {20000.0, 199.00, 49.799, 26.284, 18.314, 14.544, 12.404, 11.042, 10.107, 9.4270, 8.9122, 8.5096, 8.1865, 7.9217, 7.7008, 7.5138, 7.3536, 7.2148, 7.0935, 6.9865, 6.8914, 6.8064, 6.7300, 6.6610, 6.5982, 6.5409, 6.4885, 6.4403, 6.3958, 6.3547},
            {21615.0, 199.17, 47.467, 24.259, 16.530, 12.917, 10.882, 9.5965, 8.7171, 8.0807, 7.6004, 7.2258, 6.9257, 6.6803, 6.4760, 6.3034, 6.1556, 6.0277, 5.9161, 5.8177, 5.7304, 5.6524, 5.5823, 5.5190, 5.4615, 5.4091, 5.3611, 5.3170, 5.2764, 5.2388},
            {22500.0, 199.25, 46.195, 23.155, 15.556, 12.028, 10.050, 8.8051, 7.9559, 7.3428, 6.8809, 6.5211, 6.2335, 5.9984, 5.8029, 5.6378, 5.4967, 5.3746, 5.2681, 5.1743, 5.0911, 5.0168, 4.9500, 4.8898, 4.8351, 4.7852, 4.7396, 4.6977, 4.6591, 4.6233},
            {23056.0, 199.30, 45.392, 22.456, 14.940, 11.464, 9.5221, 8.3018, 7.4711, 6.8723, 6.4217, 6.0711, 5.7910, 5.5623, 5.3721, 5.2117, 5.0746, 4.9560, 4.8526, 4.7616, 4.6808, 4.6088, 4.5441, 4.4857, 4.4327, 4.3844, 4.3402, 4.2996, 4.2622, 4.2276},
            {23437.0, 199.33, 44.838, 21.975, 14.513, 11.073, 9.1554, 7.9520, 7.1338, 6.5446, 6.1015, 5.7570, 5.4819, 5.2514, 5.0708, 4.9134, 4.7789, 4.6627, 4.5614, 4.4721, 4.3931, 4.3225, 4.2591, 4.2019, 4.1500, 4.1027, 4.0594, 4.0197, 3.9830, 3.9492},
            {23715.0, 199.36, 44.434, 21.622, 14.200, 10.786, 8.8854, 7.6942, 6.8849, 6.3025, 5.8648, 5.5245, 5.2529, 5.0313, 4.8473, 4.6920, 4.5594, 4.4448, 4.3448, 4.2569, 4.1789, 4.1094, 4.0469, 3.9905, 3.9394, 3.8928, 3.8501, 3.8110, 3.7749, 3.7416},
            {23925.0, 199.37, 44.126, 21.352, 13.961, 10.566, 8.6781, 7.4960, 6.6933, 6.1159, 5.6821, 5.3451, 5.0761, 4.8566, 4.6743, 4.5207, 4.3893, 4.2769, 4.1770, 4.0900, 4.0128, 3.9440, 3.8822, 3.8264, 3.7758, 3.7297, 3.6875, 3.6487, 3.6130, 3.5801},
            {24091.0, 199.39, 43.882, 21.139, 13.772, 10.391, 8.5138, 7.3386, 6.5411, 5.9676, 5.5368, 5.2021, 4.9351, 4.7173, 4.5364, 4.3838, 4.2535, 4.1410, 4.0428, 3.9564, 3.8799, 3.8116, 3.7502, 3.6949, 3.6447, 3.5989, 3.5571, 3.5186, 3.4832, 3.4505},
            {24224.0, 199.40, 43.686, 20.967, 13.618, 10.250, 8.3803, 7.2107, 6.4171, 5.8467, 5.4182, 5.0855, 4.8199, 4.6034, 4.4236, 4.2719, 4.1423, 4.0305, 3.9329, 3.8470, 3.7709, 3.7030, 3.6420, 3.5870, 3.5370, 3.4916, 3.4499, 3.4117, 3.3765, 3.3440}
        });
    }
    /**
     * Helper method to populate the F-distribution table for a specific confidence level.
     * @param confidence The confidence level in percentage.
     * @param values Matrix of F-distribution values where rows represent numerator degrees of freedom and columns represent denominator degrees of freedom.
     */
    private static void putFDistribution(double confidence, Double[][] values) {
        HashMap<Integer, HashMap<Integer, Double>> dfMap = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            HashMap<Integer, Double> innerMap = new HashMap<>();
            for (int j = 0; j < values[i].length; j++) {
                innerMap.put(j + 1, values[i][j]);  // Populate the inner map
            }
            dfMap.put(i + 1, innerMap);  // Put the inner map in the dfMap
        }
        fValues.put(confidence, dfMap);  // Now compatible with the fValues map type
    }


    // -------------------------------------------------Getting Values Methods-------------------------------------------------


   /**
     * Retrieves the Z-value corresponding to a specified confidence level.
     * @param confidenceLevel The desired confidence level in percentage.
     * @return The Z-value if found, otherwise a default value of 1.96 which corresponds to a 95% confidence level.
     */
    public static double getZValue(double confidenceLevel) {
        if (zTable.containsKey(confidenceLevel)) {
            return zTable.get(confidenceLevel);
        } else {
            // If the confidence level is not in the table, return a default value or handle it accordingly
            // Here, we return 1.96 which corresponds to 95% confidence level
            return 1.96;
        }
    }

    /**
     * Retrieves the T-value corresponding to a specified confidence level and sample size.
     * @param confidenceLevel The desired confidence level in percentage.
     * @param sampleSize The sample size, which corresponds to degrees of freedom in the context of T-values.
     * @return The T-value if found, otherwise a default value of 1.96.
     * @throws IllegalArgumentException if the T-value is not found in the table.
     */
    public static double getTValue(double confidenceLevel, int sampleSize) {
        if (tTable.containsKey(confidenceLevel)) {
            return tTable.get(confidenceLevel).get(sampleSize);
        } else {
            // Handle the case when t-value is not available in the table
            // You can return a default value or throw an exception based on your requirement
            return 1.96;
        }
    }

    /**
     * Retrieves the left chi-square value corresponding to a specified confidence level and degrees of freedom.
     * @param confidenceLevel The desired confidence level in percentage.
     * @param degreesOfFreedom The degrees of freedom.
     * @return The left chi-square value if found.
     * @throws IllegalArgumentException if the value is not found in the table.
     */
    public static double getLChiValue(double confidenceLevel, int degreesOfFreedom) {
        if (LChiSquare.containsKey(confidenceLevel)) {
            HashMap<Integer, Double> dfMap = LChiSquare.get(confidenceLevel);
            if (dfMap.containsKey(degreesOfFreedom)) {
                return dfMap.get(degreesOfFreedom);
            } else {
                throw new IllegalArgumentException("Left Chi-square value not found for the given degrees of freedom");
            }
        } else {
            throw new IllegalArgumentException("Left Chi-square value not found for the given confidence level");
        }
    }

    /**
     * Retrieves the right chi-square value corresponding to a specified confidence level and degrees of freedom.
     * @param confidenceLevel The desired confidence level in percentage.
     * @param degreesOfFreedom The degrees of freedom.
     * @return The right chi-square value if found.
     * @throws IllegalArgumentException if the value is not found in the table.
     */
    public static double getRChiValue(double confidenceLevel, int degreesOfFreedom) {
        if (RChiSquare.containsKey(confidenceLevel)) {
            HashMap<Integer, Double> dfMap = RChiSquare.get(confidenceLevel);
            if (dfMap.containsKey(degreesOfFreedom)) {
                return dfMap.get(degreesOfFreedom);
            } else {
                throw new IllegalArgumentException("Right Chi-square value not found for the given degrees of freedom");
            }
        } else {
            throw new IllegalArgumentException("Right Chi-square value not found for the given confidence level");
        }
    }

    /**
     * Retrieves the F-distribution value corresponding to a specified confidence level, numerator and denominator degrees of freedom.
     * @param confidenceLevel The desired confidence level in percentage.
     * @param df1 The numerator degrees of freedom.
     * @param df2 The denominator degrees of freedom.
     * @return The F-distribution value if found.
     * @throws IllegalArgumentException if the value is not found in the table.
     */
    public static double getFValue(double confidenceLevel, int df1, int df2) {
        if (fValues.containsKey(confidenceLevel)) {
            HashMap<Integer, HashMap<Integer, Double>> dfMap = fValues.get(confidenceLevel);
            if (dfMap.containsKey(df1)) {
                HashMap<Integer, Double> innerMap = dfMap.get(df1);
                if (innerMap.containsKey(df2)) {
                    return innerMap.get(df2);
                } else {
                    throw new IllegalArgumentException("F-distribution value not found for the given denominator degrees of freedom");
                }
            } else {
                throw new IllegalArgumentException("F-distribution value not found for the given numerator degrees of freedom");
            }
        } else {
            throw new IllegalArgumentException("F-distribution value not found for the given confidence level");
        }
    }
    
}

