import java.util.regex.*;

public class Match {
    public static void main(String[] args) {
        String text = "Hello, this is a sample text with some numbers: 12345";
        String pattern = "\\d+";

        Pattern regexPattern = Pattern.compile(pattern);
        Matcher matcher = regexPattern.matcher(text);

        while (matcher.find()) {
            System.out.println("Match found: " + matcher.group());
        }
    }
}
