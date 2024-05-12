//Using optional to determine whether the object type is null
//Avoid producing the NullPointerException

import java.util.Optional;

public class Main{
	public static void main(String[] args){
		String value1 = "Hello, World.";
		String value2 = null;

		Optional<String> optionalValue1 = Optional.ofNullable(value1);
		Optional<String> optionalValue2 = Optional.ofNullable(value2);
	
		printValue(optionalValue1);	
		printValue(optionalValue2);
	
	}

	public static void printValue(Optional<String> optionalValue){
		if (optionalValue.isPresent()) {
			System.out.println("Value is present:"+ optionalValue.get());
	}	else {
			System.out.println("Value is absent.");
		}
	}
}