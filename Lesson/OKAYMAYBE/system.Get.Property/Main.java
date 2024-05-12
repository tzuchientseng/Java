public class Main{
	public static void main(String[] args){
		System.out.println("args[0]: " + args[0]);
		System.out.println("System Property:" + System.getProperty("foo"));
//implement
		var debug = Boolean.parseBoolean(System.getProperty("debug"));
		if(debug){
			System.out.println("debug");
			}
		}
}