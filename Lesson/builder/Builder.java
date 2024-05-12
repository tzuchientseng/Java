package builder;
public class Builder{
	public static void main(String[] args){
		var u = User.builder()
				   	.name("Alice")
					.password("1234")
					.age(18)
					.build();
		System.out.println(u);
	}
}

final class User{
	private final String name;
	private final String password;
	private final int age;
	public static UserBuilder builder(){
		return new UserBuilder();
	}
	private User(String name, String password, int age){
		this.name = name;
		this.password = password;
		this.age = age;
	}
	public final String toString(){
		return String.format("User[name=%s, password=%s, age=%s]",
			this.name, this.password, this.age);
	}
	public final static class UserBuilder{
		private String name;
		private String password;
		private int age;
		public User build(){
			return new User(name, password, age);
		}
		public UserBuilder name(String name){
			this.name = name;
			return this;
		}
		public UserBuilder password(String password){
			this.password = password;
			return this;
		}
		public UserBuilder age(int age){
			this.age = age;
			return this;
		}
	}
}