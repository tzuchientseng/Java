import java.util.HashMap; 
import java.util.Map; 

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder("abcabcabc");
        Solution o = new Solution();
        System.out.println("Length of the longest substring without repeating characters: " + o.lengthOfLongestSubstring(str.toString()));
    }
}

class Solution {//Sliding Window
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        // Current index of character
        Map<Character, Integer> map = new HashMap<>();

        // Try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                // Move the start of the window to the right of the first occurrence
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
        /*
            Time complexity: O(n)：這裡的 n 是字串 s 的長度。
            Space complexity: O(min(m, n))：這裡的 m 是字元集的大小，n 是字串 s 的長度。
        */
    }
}
