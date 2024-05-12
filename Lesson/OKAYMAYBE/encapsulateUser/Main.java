public class Main{
	public static void main(String[] args){
		var u = new User("M12283XXXX","Sunny Tseng");

		System.out.println(u.getId());
		System.out.println(u.getName());

		System.out.println(u);
		
	}
}
class User{
	private String id;
	private String name;
	public User(String id, String name){
		this.id = id;
		this.name = name;
	}
	public String getId(){return this.id;}
	public String getName(){return this.name;}

	public boolean equals(Object o){return super.equals(0);}
	public int hashCode(){return super.hashCode();}
	public String toString(){return super.toString();}
}