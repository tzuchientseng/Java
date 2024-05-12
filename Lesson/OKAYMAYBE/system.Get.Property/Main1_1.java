public class Main1_1{
	public static void main(String[] args){
		System.out.println("args[0]: " + args[0]);
		System.out.println("System Property:" + System.getProperty("foo"));
//implement
		var debug = Boolean.parseBoolean(System.getProperty("debug"));
		if(debug){
			System.out.println("debug");
			}
		A a = null;
		if("B".equals(args[0])){
			a = new B();
		}else if("C".equals(args[0])){
			a = new C();	
	 	}
 	a.say();
	}
}
interface A{
	public void say();

}
class B implements A{
	public void say(){
		System.out.println("B");
	}
}
class C implements A{
	public void say(){
		System.out.println("C");
	}
}