package Questions.Cyclic;
// asked in amazon 
// https://leetcode.com/problems/first-missing-positive/description/

public class FindMissingPositive {
    public static void main(String[] args) {
        int[] arr = {3,4,-1,1};
        int ans =firstMissingPositive(arr);
        System.out.println("the ans is : "+ ans);
    }

    public static int firstMissingPositive(int[] nums){
        int i = 0;
        while(i<nums.length){
            int correct = nums[i]-1;
            if(nums[i] > 0 && nums[i] <= nums.length && nums[correct] != nums[i]){
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            }else{
                i++;
            }
        }
        for(i = 0; i<nums.length; i++){
            if(nums[i] != i+1){
                return i+1;
            }
        }
        return nums.length +1;
    }
}
