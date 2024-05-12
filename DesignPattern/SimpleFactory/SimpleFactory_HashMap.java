package DesignPattern.SimpleFactory;

import java.util.HashMap;
import java.util.Map;

// Main class to test the operations
public class SimpleFactory_HashMap {
    public static void main(String[] args) {
        String strOperate = "+";
        double numberA = 40d;
        double numberB = 70d;

        Operation oper = OperationFactory.createOperation(strOperate);
        double result = oper.getResult(numberA, numberB);
        System.out.println("Result: " + result);
    }
}
// Factory class to create operations
class OperationFactory {
    private static final Map<String, Operation> operations = new HashMap<>();

    static {
        operations.put("+", new Add());
        operations.put("-", new Subtract());
        operations.put("*", new Multiply());
        operations.put("/", new Divide());
    }

    public static Operation createOperation(String operate) {
        Operation operation = operations.get(operate);
        if (operation == null) {
            throw new IllegalArgumentException("Invalid operation: " + operate);
        }
        return operation;
    }
}
// Abstract class for operation
abstract class Operation {
    public abstract double getResult(double numberA, double numberB);
}

// Class for addition operation
class Add extends Operation {
    @Override
    public double getResult(double numberA, double numberB) {
        return numberA + numberB;
    }
}

// Class for subtraction operation
class Subtract extends Operation {
    @Override
    public double getResult(double numberA, double numberB) {
        return numberA - numberB;
    }
}

// Class for multiplication operation
class Multiply extends Operation {
    @Override
    public double getResult(double numberA, double numberB) {
        return numberA * numberB;
    }
}

// Class for division operation
class Divide extends Operation {
    @Override
    public double getResult(double numberA, double numberB) {
        if (numberB != 0) {
            return numberA / numberB;
        } else {
            System.out.println("Error: Division by zero!");
            return Double.NaN;
        }
    }
}

/* 
package DesignPattern.SimpleFactory;

// Main class to test the operations
public class SimpleFactory_enum {
    public static void main(String[] args) {
        String strOperate = "+";
        double numberA = 40d;
        double numberB = 70d;

        Operation oper = OperationFactory.createOperation(strOperate);
        double result = oper.getResult(numberA, numberB);
        System.out.println("Result: " + result);
    }
}

// Enum for different operations
enum OperationType {
    ADD, SUBTRACT, MULTIPLY, DIVIDE;

    public static OperationType fromString(String operation) {
        switch (operation) {
            case "+":
                return ADD;
            case "-":
                return SUBTRACT;
            case "*":
                return MULTIPLY;
            case "/":
                return DIVIDE;
            default:
                throw new IllegalArgumentException("Invalid operation: " + operation);
        }
    }
}

// Abstract class for operation
abstract class Operation {
    public abstract double getResult(double numberA, double numberB);
}

// Class for addition operation
class Add extends Operation {
    @Override
    public double getResult(double numberA, double numberB) {
        return numberA + numberB;
    }
}

// Class for subtraction operation
class Subtract extends Operation {
    @Override
    public double getResult(double numberA, double numberB) {
        return numberA - numberB;
    }
}

// Class for multiplication operation
class Multiply extends Operation {
    @Override
    public double getResult(double numberA, double numberB) {
        return numberA * numberB;
    }
}

// Class for division operation
class Divide extends Operation {
    @Override
    public double getResult(double numberA, double numberB) {
        if (numberB != 0) {
            return numberA / numberB;
        } else {
            System.out.println("Error: Division by zero!");
            return Double.NaN;
        }
    }
}

// Factory class to create operations
class OperationFactory {
    public static Operation createOperation(String operate) {
        OperationType operationType = OperationType.fromString(operate);
        switch (operationType) {
            case ADD:
                return new Add();
            case SUBTRACT:
                return new Subtract();
            case MULTIPLY:
                return new Multiply();
            case DIVIDE:
                return new Divide();
            default:
                throw new IllegalArgumentException("Invalid operation: " + operate);
        }
    }
}
*/