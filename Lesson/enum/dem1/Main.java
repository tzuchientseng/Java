public class Main{
	public static void main(String[] args){
	System.out.println(Foo.A);
	System.out.println(Foo.valueOf("A"));
	Foo[] ff = Foo.values();
	for(Foo f: ff){
		System.out.println(f);
		}
	}
}

enum Foo{
	A, B, C
//	A, B, C;
}