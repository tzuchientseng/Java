import java.util.Arrays;
import java.util.logging.Logger;

public class Password {
    private static final Logger logger = Logger.getLogger(Password.class.getName());

    public static void main(String[] args) {
        char[] sensitiveData = {'p', 'a', 's', 's', 'w', 'o', 'r', 'd'};

        try {
            processSensitiveData(sensitiveData);
        } catch (Exception e) {
            logger.severe("An error occurred while processing data. But we won't log sensitive data.");
        } finally {
            Arrays.fill(sensitiveData, '\0');
        }

        System.out.println("Sensitive data after processing: " + Arrays.toString(sensitiveData));
    }

    private static void processSensitiveData(char[] data) {
        char[] _data = Arrays.copyOf(data, data.length);
        for (int i = 2; i < data.length - 2; i++) {
            _data[i] = '*';
        }
        System.out.println(Arrays.toString(data));
        System.out.println(Arrays.toString(_data));
    }
}
