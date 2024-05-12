package HW.Account;

import java.util.Scanner;

public class Main {
	static Scanner s = new Scanner(System.in);

@FunctionalInterface
	interface CardReader{
		void execute(String type);
	}
	private static void run(String type, CardReader o){
		o.execute(type);
	}

	public static void main(String[] args){
	Account User = new User();
//
	while(true){
	run("@A1234", type -> System.out.println(type + " executing!!"));
	System.out.println("----------------------------------");
	var prompt = """
		Deposit enter:'1' 
		Withdraw enter:'2'
		""";
	System.out.print(prompt);
	System.out.println("->Balance:" + User.getBalance());
	System.out.println("----------------------------------");
	int i = s.nextInt();
	if(i == 1){
		System.out.println("Deposit Amount:");
		double add = s.nextDouble();
		User.Deposit(add);
		// System.out.println("\nBalance:"  + User.getBalance()+"\n");
	} else if(i == 2){
		System.out.println("Deduction Amount:");
		double deduct = s.nextDouble();
		try {//What was originally going to be done
			User.Withdrawal(deduct);
			// System.out.println("\nBalance:" + User.getBalance() + "\n");
		} catch (InsufficientFundsException e) {
			System.out.println("Error: " + e.getMessage());
		}
	} else{
		System.out.println("Valid!");
	}

	}
	}
}

interface Account {
 	void Deposit(double money);
    void Withdrawal(double money) throws InsufficientFundsException;
    double getBalance();
}

class User implements Account {
	private double balance = 0;

	@Override
	public void Deposit(double add) {
		balance += add;
	}

	@Override
   	public void Withdrawal(double deduct) throws InsufficientFundsException{
	    if (deduct > balance) {
        throw new InsufficientFundsException("Insufficient funds. Cannot withdraw more than the available balance.");
        }
    	balance -= deduct;
	}

	@Override
	public double getBalance() {
		return balance;
	}
}

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}