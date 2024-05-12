//Using optional to determine whether the object type is null
//Avoid producing the NullPointerException

import java.util.Optional;

public class Main2{
		public static void main(String[] args){
//previous
//		System.out.println(getDataFromDatabase().toUpperCase());

//after
		var o = getDataFromDatabase2();
		o.ifPresent(s->System.out.println(s.toUpperCase()));

	}
//previous			  
//	public static String getDataFromDatabase(){
//		return null;
//	}

//after
	public static Optional<String> getDataFromDatabase2(){
//		return Optional.empty();
		return Optional.ofNullable(null);
	}
}