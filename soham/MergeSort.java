package soham;
import java.util.Arrays;
public class MergeSort {
    public static void main(String[] args){
        int[] arr = {5,4,3,2,1};
        int[] ar = mergeSort(arr);
        System.out.println(Arrays.toString(ar));
    }

    private static int[] mergeSort(int[] arr){
        if(arr.length == 1){
            return arr;
        }
        int mid = arr.length/2;
        int[] left = mergeSort(Arrays.copyOfRange(arr,0,mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr,mid,arr.length));
        return merge(left,right);
    }

    private static int[] merge(int []left, int []right){
        int[] ans = new int[left.length +right.length];
        int i =0;
        int j = 0;
        int k=0;
        while(left.length>i && right.length>j){
            if(left[i] > right[j]){
                ans[k] = right[j];
                j++;
            }else{
                ans[k] = left[i];
                i++;
            }
            k++;
        }
        while(left.length>i){
            ans[k]=left[i];
            i++;
            k++;

        }
        while(right.length>j){
            ans[k]=right[j];
            j++;
            k++;

        }

        return ans;
    }

}
