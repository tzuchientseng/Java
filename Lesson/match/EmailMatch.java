import java.util.regex.*; 

public class EmailMatch{
	public static void main(String[] args){ 
	String email = "example@example.com";
	String pattern = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";

	boolean isValid = email.matches(pattern); 
	System.out.println("Email is valid: " + isValid);
	}
}