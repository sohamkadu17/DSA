package Practice_questions.Recursion;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        selection(arr, 5, 0, 0);
        System.out.println(Arrays.toString(arr));
    }

    private static void selection(int[] arr, int idx, int curr, int max) {
        if (idx == 0) {
            return;
        }
        if (curr < idx && curr >= 0) {
            if (arr[curr] > arr[max]) {
                selection(arr, idx, curr + 1, curr);
            }else{
                selection(arr, idx, curr + 1, max);
            }
        }else{
            int temp = arr[max];
            arr[max]= arr[idx-1];
            arr[idx-1] = temp;
            selection(arr,idx-1,0,0);
        }

    }

}
