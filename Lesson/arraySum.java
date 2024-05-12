import java.util.HashMap;

public class arraySum {
    public static void main(String[] args) {
        Solution o = new Solution();
        int[] result = o.twoSum(new int[]{1, 2, 3, 4}, 6);
        System.out.println("Indices: " + result[0] + ", " + result[1]);
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Map to store each number along with its index
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            // Check if the complement exists in the map
            if (map.containsKey(complement)) {
                // Return the indices of the two numbers
                return new int[]{map.get(complement), i};
            }
            // Put the current number and its index into the map
            map.put(nums[i], i);
        }
        
        // If no solution is found, return an empty array
        return new int[]{};
    }
}
