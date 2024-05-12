public class Main {
	public static void main(String[] args){
		String s1 = String.format("%2$(,7d %1$(,7d", 1234, -1234);
		String s2 = String.format("%2$(,.4f %1$(,.4f", 1234.0, -1234.0); System.out.println(s1);
	System.out.println(s2);
	}
}
