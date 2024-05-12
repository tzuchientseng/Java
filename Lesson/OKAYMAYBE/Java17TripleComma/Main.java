public class Main{
	public static void main(String[] args){
		var s = """
				abc
					def
						123
				""";
		System.out.println(s);

		String s1 = "abc\n"+"def\n"+"123\n";
		System.out.println(s1);

	}
}