import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter matrix elements, continue until an empty line is entered
        System.out.println("Please enter matrix elements line by line, separated by spaces. Press Enter after each line, and press Enter again to finish:");

        // Use ArrayList to temporarily store each row of elements
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

        // Read each line of user input until an empty line is entered
        String line;
        while (!(line = scanner.nextLine()).isEmpty()) {
            String[] elements = line.split("\s+");
            // String[] elements = line.split("\\s+"); //Java regex

            // Create a new ArrayList to store the elements of one row
            ArrayList<Integer> row = new ArrayList<>();

            // Convert each element to an Integer and add it to the ArrayList
            for (String element : elements) {
                row.add(Integer.parseInt(element));
            }

            // Add the ArrayList for this row to the matrix
            matrix.add(row);
        }

        // Display the entered matrix
        System.out.println("The matrix you entered is:");
        for (ArrayList<Integer> row : matrix) {
            for (Integer element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }

        // Close the Scanner
        scanner.close();
    }
}
