import java.util.Arrays;

public class Test {
    public static void mian(String[] args){
        Solution o = new Solution();
            int[] nums1 = {1, 3};
            int[] nums2 = {2};
            System.out.println("Median is: " + o.findMedianSortedArrays(nums1, nums2)); // Output: 2.0
    
            int[] nums3 = {1, 2};
            int[] nums4 = {3, 4};
            System.out.println("Median is: " + o.findMedianSortedArrays(nums3, nums4)); // Output: 2.5
    }    
}

class Solution{
    public double findMedianSortedArrays(int[] a, int[] b){
        Arrays.sort(a);
        Arrays.sort(b);
        if (a.length > b.length){
            return findMedianSortedArrays(b, a);
        }       

        return ;
    }
}