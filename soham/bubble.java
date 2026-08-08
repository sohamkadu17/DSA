package soham;

import java.util.Arrays;

public class bubble {
     public static void main(String[] args){
        int []arr = {5,4,2,7,8,0,6};

        bubbleSort(arr);
        System.out.println("Sorted array is:" + Arrays.toString(arr));
     }
     static void bubbleSort(int []arr){
        for(int i = 0; i< arr.length-1;i++){
            boolean swapped = false;
            for(int j = 0; j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            if(swapped == false){
                break;
            }
        }
     }     
}
