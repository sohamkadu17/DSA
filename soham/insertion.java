package soham;

import java.util.Arrays;

public class insertion {
    public static void main(String[] args){
        int [] arr = {9,8,7,6,5,4,3,2,1,0};
        insertionsort(arr);
        System.out.println("Sorted Array is :" + Arrays.toString(arr));
    }

    static void insertionsort(int[] arr){
        for(int i=1;i<arr.length;i++){
            int j = i-1;
            while(j>=0 && arr[j]>arr[j+1]){
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
                j--;
            }
        }
    }
}
