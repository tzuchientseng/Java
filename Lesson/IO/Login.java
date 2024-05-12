package IO;

import java.io.*;

public class Login {
    public static void main(String[] args){
        Console console = System.console();
        boolean isValid = false;
        String account = "";
        String password = "";
        do {
            account = console.readLine("%s", "Account: ");
            password = new String(console.readPassword("%s", "password: "));
            if("Sunny".equals(account) && "open".equals(password)){//"The longer the password, the better."
                System.out.println("Login Success");
                isValid = true;
            } else {
                System.out.println("Login Fail");
            }

        }while(!isValid);
    }
}
