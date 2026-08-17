package soham;
import java.util.Arrays;
public class QuickSort{
    private static void Sort(int[] arr ,int low , int high ){
        if(low >= high){
            return ;
        }
        int s= low;
        int e = high;
        int mid = s+(e-s)/2;
        int pivot = arr[mid];
        while(s<=e){
            while(arr[s] < pivot){
                s++;
            }
            while(arr[e] > pivot){
                e--;
            }
            if(s<=e){
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                s++;
                e--;
            }

        }



        Sort(arr, s, high);
        Sort(arr , low , e);
    }

    public static void main(String[] args){
        int[] arr = {4,7,2,8,9,3,1,0};
        System.out.println(Arrays.toString(arr));
        Sort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}