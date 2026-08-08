package soham;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int [] arr = {7,5,8,4,9,3,0,4,5,6};
        selectionSort(arr);
        System.out.println("Sorted array is "+ Arrays.toString(arr));
    }

    static void selectionSort(int[] arr) {
        int n = arr.length -1;
        for(int i = 0; i<arr.length-1; i++){
            int maxIndex = findMax(arr, n);
            int temp = arr[maxIndex];
            arr[maxIndex] = arr[n];
            arr[n] = temp;
            n--;
        }
    }

    static int findMax(int[] arr, int end) {
        int max = 0;
        for (int i = 0; i <= end; i++) {
            if (arr[i] > arr[max]) {
                max = i;
            }
        }
        return max;

    }

}
