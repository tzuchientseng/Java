public class Main {
	public static void main(String[] args) { 
		try {
			int result1 = divide(10, 0); 
			int result2 = divide(0, 0);
			System.out.println("result1: " + result1);
			System.out.println("result2: " + result2);
		}catch (ArithmeticException ex) { 
			System.out.println("catch1: " + ex.getMessage());
			System.out.println("catch2:(���ݳQ����) " + ex.getMessage());
		}catch (Exception ex) {
			System.out.println("catch1: " + ex.getMessage());
			System.out.println("catch2: " + ex.getMessage());
		}finally{
			System.out.println("finally");
		}
	}

	public static int divide(int num1, int num2) {
		return num1 / num2;
	}
}
