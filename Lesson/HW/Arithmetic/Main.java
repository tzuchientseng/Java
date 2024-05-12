package HW.Arithmetic;

public class Main {
    public static void main(String[] args) {
        double operand1 = 111.11;
        double operand2 = 222.22;

        for (Operator operator : Operator.values()) {
            double result = operator.sol(operand1, operand2);
            System.out.println(operand1 + " " + operator.getSymbol() + " " + operand2 + " = " + result);
        }
    }
}

interface Arithmetic {
    double sol(double operand1, double operand2);
}

enum Operator implements Arithmetic {
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
    private final Arithmetic arithmetic;

    // Constructor(Only private or package)
    private Operator(String symbol, Arithmetic arithmetic) {
        this.symbol = symbol;
        this.arithmetic = arithmetic;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public double sol(double operand1, double operand2) {
        return arithmetic.sol(operand1, operand2);
    }
}
