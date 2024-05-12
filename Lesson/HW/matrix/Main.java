package HW.matrix;

import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        int[] arr = new int[]{4,2,3,8,5,6,1,8,9,10};
        Arrays.sort(arr);
        var sum = 0;
        for(int i: arr){
            sum += i;
        }
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + (double)sum/arr.length);
        System.out.println("Min: " + arr[0]);
        System.out.println("Max: " + arr[arr.length-1]);
    }
}
