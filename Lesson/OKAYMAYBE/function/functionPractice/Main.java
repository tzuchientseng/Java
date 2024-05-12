import java.util.*;

public class Main{
	public static void main(String[] args){

	while(true){
		Scanner s = new Scanner(System.in);
		var o = new B();
		var ans = o.plus(s.nextDouble(), s.nextDouble());
		System.out.println(ans);
	}

}
}

class A{
	
	 public double plus(double a , double b){
		return a + b;
	}


}

class B extends A{
		double mu(double a , double b){
		return a * b;
	}

}