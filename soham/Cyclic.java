package soham;
import java.util.Arrays; 
public class Cyclic {
    public static void main(String[] args) {
        int [] arr = {3,5,4,2,1};
        cyclicSort(arr);
        System.out.println("Sorted array is : " + Arrays.toString(arr));
    }

    static void cyclicSort(int[] arr){

        int i = 0;
        while(i<arr.length){
            if(arr[i] != i+1){
                int temp = arr[i];
                arr[i]= arr[temp-1];
                arr[temp-1] = temp;
            }
            if(arr[i] == i+1){
                i++;
            }

        }
    }
}
