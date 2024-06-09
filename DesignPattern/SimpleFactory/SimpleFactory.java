package DesignPattern.SimpleFactory;

// Main class to test the operations
public class SimpleFactory {
   public static void main(String[] args) {
      /* 
      Operation add = createOperation("+");
      Operation subtract = createOperation("-");
      Operation multiply = createOperation("*");
      Operation divide = createOperation("/");
      System.out.println("Addition: " + add.getResult(10, 5));
      System.out.println("Subtraction: " + subtract.getResult(10, 5));
      System.out.println("Multiplication: " + multiply.getResult(10, 5));
      System.out.println("Division: " + divide.getResult(10, 5));
      */
      String strOperate = "+";
      double numberA = 40d;
      double numberB = 70d;

      Operation oper = SimpleFactory.createOperation(strOperate);
      double result = oper.getResult(numberA, numberB);
      System.out.println("Result: " + result);
    }

    public static Operation createOperation(String operate) {
        Operation oper = null;
        switch (operate) {
            case "+":
                oper = new Add();
                break;
            case "-":
                oper = new Subtract();
                break;
            case "*":
                oper = new Multiply();
                break;
            case "/":
                oper = new Divide();
                break;
            default:
                System.out.println("Invalid operation");
                break;
        }
        return oper;
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

// Bad Demo
/*
package DesignPattern;
import java.util.Scanner;

public class SimpleFactory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter A number:");
        String A = sc.nextLine();
        System.out.println("Enter operation:");
        String o = sc.nextLine();
        System.out.println("Enter B number:");
        String B = sc.nextLine();
        double resault = 0d;
        if(o.equals("+"))
           resault = Double.parseDouble(A) + Double.parseDouble(B);
        if(o.equals("-"))
           resault = Double.parseDouble(A) - Double.parseDouble(B);
        if(o.equals("*"))
           resault = Double.parseDouble(A) * Double.parseDouble(B);
        if(o.equals("/"))
           resault = Double.parseDouble(A) / Double.parseDouble(B);
        System.out.println("Result: " + resault);
    }
}
*/

