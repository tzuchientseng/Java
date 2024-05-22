public class StringReverser {
    public static void main(String[] args) {
        System.out.println(reverseSegment("abcdefd", 'd'));  // Output: "dcbaefd"
        System.out.println(reverseSegment("xyxzxe", 'z'));   // Output: "zxyxxe"
        System.out.println(reverseSegment("abcd", 'z'));     // Output: "abcd"
    }
    public static String reverseSegment(String word, char ch) {
        // Time Complexity:  O(n)
        // Space Complexity: O(n)
        int index = word.indexOf(ch);
        if (index == -1) {
            // ch is not found, return the original string
            return word;
        }

        // Reverse the substring from 0 to index
        StringBuilder reversedSegment = new StringBuilder(word.substring(0, index + 1));
        reversedSegment.reverse();
        
        // Append the part of the string after index
        return reversedSegment.toString() + word.substring(index + 1);
    }
}

