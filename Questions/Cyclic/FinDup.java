package Questions.Cyclic;

import java.util.ArrayList;
import java.util.List;

public class FinDup{
    public static void main(String[] args){
        int[] arr = {4,3,2,7,8,2,3,1};
        List<Integer> ans = new ArrayList<>();
        ans = findDuplicates(arr);
        System.out.println("the ans is : "+ ans);
    }



    static List<Integer> findDuplicates(int[] nums) {
       List<Integer> ans = new ArrayList<>();
       int i = 0;
       while(i<nums.length){
        int current = nums[i]-1;
        if(nums[i] < nums.length && nums[i] != nums[current]){
            int temp = nums[current];
            nums[i] = nums[current];
            nums[current] = temp;
        }else{
            i++;
        }
       } 
       for(int index = 0; index<nums.length ; index++){
        if(nums[index] != index+1){
            ans.add(index+1);
        }
       }
       return ans;
    }
}