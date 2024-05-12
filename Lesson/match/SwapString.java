import java.util.regex.*; 
	public class SwapString {
		public static void main(String[] args) {
			String sentence = "I love Java! Java is awesome."; 
			String pattern = "Java";
			String replacement = "Python";

			Pattern regexPattern = Pattern.compile(pattern);
			Matcher matcher = regexPattern.matcher(sentence);
			String modifiedSentence = matcher.replaceAll(replacement);
 	
			System.out.println("Modified sentence: " + modifiedSentence);
	}
}

