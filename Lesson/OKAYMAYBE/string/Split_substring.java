public class Split_substring {
	public static void main(String[] args){ 
		String s = "A 1,B 2,C 3";
		String[] ss = s.split(",", -1); for(String s1: ss) {
			System.out.println(s1);
		}

		String path = "/aa/bb/cc"; foo(path, 0);
 
}

private static void foo(String s, int index) { int end = s.indexOf("/", index);
		if(end>-1) {		
			System.out.println(s.substring(index, end)); foo(s, end+1);
			} else {	
			System.out.println(s.substring(index));
		}
	}
}