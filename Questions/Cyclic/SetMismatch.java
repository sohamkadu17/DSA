package Questions.Cyclic;
import java.util.Arrays;


public class SetMismatch {
    public static void main(String[] args) {
        int[] arr = {3,2,2};
        int[] ans = new int[2];
        ans = findErrorNums(arr);
        System.out.println("the ans is : "+ Arrays.toString(ans));
    }

     public static int[] findErrorNums(int[] nums) {
        int i = 0;
        int[] ans = new int[2];
        while(i<nums.length){
             if(nums[idx] != idx+1){
                ans[0] = nums[idx];
                ans[1] = idx+1;
                return ans;
            }
            int correct = nums[i]-1;
            if(nums[i] < nums.length && nums[i] != nums[correct]){
                int temp = nums[i];
                nums[i] = nums[temp -1];
                nums[temp] = temp;
            }else{
                i++;
            }
        }
        for(int idx = 0; idx<nums.length; idx++){
            if(nums[idx] != idx+1){
                ans[0] = nums[idx];
                ans[1] = idx+1;
                return ans;
            }
        }
        return ans;
    }
    
}
