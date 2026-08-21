package Questions.DailyLeetCode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class q_3069{
    public static void main(String[] args){
        int [] nums = {8,10,3,12};
        resultArray(nums);

        System.out.println(Arrays.toString(nums));
    }


// You are given a 1-indexed array of distinct integers nums of length n.

// You need to distribute all the elements of nums between two arrays arr1 and arr2 using n operations. In the first operation, append nums[1] to arr1. In the second operation, append nums[2] to arr2. Afterwards, in the ith operation:

// If the last element of arr1 is greater than the last element of arr2, append nums[i] to arr1. Otherwise, append nums[i] to arr2.
// The array result is formed by concatenating the arrays arr1 and arr2. For example, if arr1 == [1,2,3] and arr2 == [4,5,6], then result = [1,2,3,4,5,6].

// Return the array result.

    public static int[] resultArray(int[] nums) {
        // int[] ans = Arrays.copyOf(nums, nums.length);
        // int b = 1;
        // int a =0;
        // for(int i = 2; i< nums.length; i++){
        //     if(nums[a]>nums[b]){
        //         int temp = nums[i];
        //         nums[i] = nums[b];
        //         nums[b] = temp;
        //         b++;
        //         a++;
        //     }else{
        //         b++;
        //     }
        // }
            // return nums;
        // lets use List

        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();

        arr1.add(nums[0]);
        arr2.add(nums[1]);

        for(int i = 2; i< nums.length; i++){
            int lastArr1= arr1.get(arr1.size()-1);
            int lastArr2 = arr2.get(arr2.size()-1);
            if(lastArr1> lastArr2){
                arr1.add(nums[i]);
            }else{
                arr2.add(nums[i]);
            }
        }

        int[] ans = new int [nums.length];
        int i = 0;
        for(int num: arr1){
            ans[i] = num;
            i++;
        }
        for(int num: arr2){
            ans[i]=num;
            i++;
        }



        return ans;




    }
}