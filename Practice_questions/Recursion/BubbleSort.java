package Practice_questions.Recursion;
import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args){
        int[] arr = {5,4,3,2,1};
        bubble(arr,4,0);
        System.out.println(Arrays.toString(arr));

    }


    private static void bubble(int[] arr, int idx, int currIdx){
        if(idx == 0){
            return;
        }

        if(currIdx<idx && currIdx>=0){
            if(arr[currIdx]>arr[idx]){
                int temp = arr[currIdx];
                arr[currIdx] =arr[idx];
                arr[idx] = temp;
            }
            bubble(arr,idx,currIdx-1);
        }else{
            bubble(arr,idx-1,0);
        }
    }
}
