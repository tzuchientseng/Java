public class Calculator{
    public static void main(String[] args) {
        double operand1 = 5.0;
        double operand2 = 2.0;

        // Iterate through all operators
        for (Operator operator : Operator.values()) {
            double result = operator.apply(operand1, operand2);
            System.out.println(operand1 + " " + operator.getSymbol() + " " + operand2 + " = " + result);
        }
    }
}

// Define an interface representing basic arithmetic operations
interface Operation {
    double apply(double operand1, double operand2);
}

// Define an enum type representing arithmetic operators
enum Operator implements Operation {
    ADD("+", (x, y) -> x + y),
    SUBTRACT("-", (x, y) -> x - y),
    MULTIPLY("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> {
        if (y != 0) {
            return x / y;
        } else {
            throw new ArithmeticException("Cannot divide by zero");
        }
    });

    private final String symbol;
    private final Operation operation;

    // Constructor
    Operator(String symbol, Operation operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    // Get the symbol
    public String getSymbol() {
        return symbol;
    }

    // Implement the interface method
    @Override
    public double apply(double operand1, double operand2) {
        return operation.apply(operand1, operand2);
    }
}
