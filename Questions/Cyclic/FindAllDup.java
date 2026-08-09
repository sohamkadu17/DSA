 package Questions.Cyclic;
import java.util.ArrayList;
import java.util.List;

class FindAllDup {
    public static void main(String[] args) {
        int[] arr = {4,3,2,7,8,2,3,3,1};
        List<Integer> ans = new ArrayList<>();
        ans = findDuplicates(arr);
        System.out.println("the ans is : "+ ans);
    }


     public static List<Integer> findDuplicates(int[] nums) {
       List<Integer> ans = new ArrayList<>();
       int i = 0;
       while(i<nums.length){
        int correct = nums[i]-1;
        if(nums[i] != nums[correct]){
            int temp = nums[i];
            nums[i] = nums[temp -1];
            nums[temp-1] = temp;
        }else{
            i++;
        }
       }
       for (int j = 0 ; j<nums.length; j++){
        if(nums[j] != j+1){
            ans.add(nums[j]);
        }
       }
       return ans;
    }
    
}