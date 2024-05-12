public class Main{
	public static void main(String[] args){
		var u1 = new User("no1", "Sunny Tseng");
 		System.out.print(u1);
		var u2 = new User("2");
		User.plus();
		System.out.print(u2);
		System.out.print(u1.getX());
		System.out.print(u2.getX());
	}
}

record User(String id, String name){
	public static int x;
	public User{
		System.out.println("Ok");
	}
	public User(String id){
		this(id, "None");
	}
	public static void plus(){
		x++;
	}
	public int getX(){
		return x;
	}
}