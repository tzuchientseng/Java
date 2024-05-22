import java.util.HashMap;

public class TwoSum {
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
            System.out.println("Map state: " + map);
        }
        // If no solution is found, return an empty array
        return new int[]{};
    }
}


// import java.util.List;
// import java.util.ArrayList;
// public class TwoSum{
//     public static void main(String[] args){
//         Solution o = new Solution(new int[]{2,7,11,15}, 9 );
//         System.out.println(o.twoSum());
//     }
// }
// class Solution{
//     // private List<Integer> ans = new ArrayList<>();
//     private int[] o ;
//     private int target;
//     public Solution(int[] o, int target){
//         this.o = o;
//         this.target = target;
//     }
//     // public List<Integer> twoSum(){    
//     //     for(int i=0; i<o.length-1; i++){
//     //         for(int j=i+1; j<o.length; j++){
//     //             if(o[i]+o[j] == target){
//     //                 ans.add(o[i]);
//     //                 ans.add(o[j]);
//     //                 return ans;
//     //             }
//     //         }  
//     //     }
//     //     return new ArrayList<>();
//     // }
//     public List<List<Integer>> twoSum(){  
//         List<List<Integer>> result = new ArrayList<>();
    
//         for(int i=0; i<o.length-1; i++){
//             for(int j=i+1; j<o.length; j++){
//                 if(o[i] + o[j] == target){
//                     List<Integer> pair = new ArrayList<>();
//                     pair.add(o[i]);
//                     pair.add(o[j]);
//                     result.add(pair);
//                 }
//             }  
//         }
//         return result;
//     }
// }