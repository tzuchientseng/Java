public class Main {

//不能寫在這 private var = 10;  private static var = 100;
	public static void main(String[] args) { 
		var message = "Hello, world!";
		var number = 10;
		var obj = new Main();

//不能這樣寫 var  = b; b = 10;
		System.out.println(message); 
		System.out.println(number);
		System.out.println(obj);
	}
//方法參數也不行	public static void aaa(var a){ }

}
