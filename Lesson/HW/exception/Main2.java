package HW.exception;

//Runtime exception case
import java.util.Scanner;

public class Main2 {
    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        Account User = new User();

        while (true) {
            System.out.println("----------------------------------");
            var prompt = """
                    Deposit enter:'1' 
                    Withdraw enter:'2'
                    """;
            System.out.print(prompt);
            System.out.println("->Balance:" + User.getBalance());
            System.out.println("----------------------------------");
            int i = s.nextInt();
            if (i == 1) {
                System.out.println("Deposit Amount:");
                double add = s.nextDouble();
                User.Deposit(add);
            // } else if (i == 2) {
            //     System.out.println("Deduction Amount:");
            //     double deduct = s.nextDouble();
            //     try {
            //         User.Withdrawal(deduct);
            //     } catch (InsufficientFundsRuntimeException e) {
            //         System.out.println("Error: " + e.getMessage());
            //     }
            // } 
          
} else if (i == 2) {
    System.out.println("Deduct Amount: ");
    double deduct = s.nextDouble();
   // No exception handling
    User.Withdrawal(deduct);
} 

            else {
                System.out.println("Valid!");
            }
        }
    }
}

interface Account {
    void Deposit(double money);

    void Withdrawal(double money);
//not notify runtimeException

double getBalance();
}

class User implements Account {
    private double balance = 0;
    
    @Override
    public void Deposit(double add) {
        balance += add;
    }
    
    @Override
    public void Withdrawal(double deduct){//not notify runtimeException
        if (deduct > balance) {
            throw new InsufficientFundsRuntimeException("Insufficient funds. Cannot withdraw more than the available balance.");
        }
        balance -= deduct;
    }

    @Override
    public double getBalance() {
        return balance;
    }
}

class InsufficientFundsRuntimeException extends RuntimeException {
    public InsufficientFundsRuntimeException(String message) {
        super(message);
    }
}
