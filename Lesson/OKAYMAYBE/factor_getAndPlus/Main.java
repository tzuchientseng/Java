public class Main {
	public static void main(String[] args) {
		int x=10,y=0;
		y = x++ + ++x;
		System.out.println("x = "+x); 
		System.out.println("y = "+y);
		
		var a = new A(10);
		System.out.println(a.getAndPlus() + a.plusAndGet());
		System.out.println(a.get());
	}
}

class A{
	private int i;
	public A(int i){
		this.i = i;
	}
	public int plusAndGet(){
		this.i += 1;
		return this.i;
	}
	public int getAndPlus(){
		var i = this.i;
		this.i += 1;
		return i;
	}
	public int get(){
		return i;
	}
}