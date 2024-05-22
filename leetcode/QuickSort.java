public class QuickSort {
    public static void main(String[] args){
        // quick sort          = moves smaller elements to left of a pivot. recursively divide array in 2 partitions
        // run-time complexity = Best case O(n lon(n))
        //                       Average case O(n log(n))
        //                       Worst case O(n^2) 
        // space complexity    = O(log(n)) due to recursion

        int[] array  =  new int[]{8,2,5,3,9,4,7,6,1};

        quicksort(array, 0, array.length - 1);

        for(int i : array){
            System.out.print(i + " ");
        }
    }
    private static void quicksort(int[] arr, int start, int end){
        if(end <= start) return; //base case
        int pivot = partition(arr, start, end);
        quicksort(arr, start, pivot - 1);
        quicksort(arr, pivot + 1, end);
    }
    private static int partition(int[] arr, int start, int end){
        int pivot  = arr[end];
        int i = start -1;

        for(int j = start; j <= end -1; j++){
            if(arr[j] < pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        int temp = arr[i];
        arr[i] = arr[end];
        arr[end] = temp;
        return i; //pivot
    }
}

