import java.util.ArrayList;
import java.util.Scanner;

public class oneDimension {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter array elements, continue until an empty line is entered
        System.out.println("Please enter array elements, separated by spaces. Press Enter after entering the elements, and press Enter again to finish:");

        // Use ArrayList to temporarily store the array elements
        ArrayList<Integer> array = new ArrayList<>();

        // Read the user input until an empty line is entered
        String line;
        while (!(line = scanner.nextLine()).isEmpty()) {
            String[] elements = line.split("\\s+");

            // Convert each element to an integer and add it to the ArrayList
            for (String element : elements) {
                array.add(Integer.parseInt(element));
            }
        }

        // Convert ArrayList to a one-dimensional array
        Integer[] arrayResult = array.toArray(new Integer[0]);

        // Display the entered array
        System.out.println("The array you entered is:");
        for (Integer element : arrayResult) {
            System.out.print(element + " ");
        }

        // Close the Scanner
        scanner.close();
    }
}
