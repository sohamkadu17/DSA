
public class MissingNums {

    public static void main(String[] args) {
        int[] arr = {3, 0, 1};
        int n = Method2(arr);
        System.out.println("Missing Num is " + n);
    }

    static int Method2(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            
            if (nums[i] != i && nums[i] < nums.length) {
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }else{
                i++;
            }
            
            

        }
        for (int j= 0; j < nums.length ; j++) {
            if (nums[j] != j) {
                return j;

            }
        }
        return nums.length;
    }

    static int missingNumber(int[] nums) {
        int i = 0;
        int sum = 0;
        int n = nums.length;
        while (i != nums.length) {
            sum = sum + nums[i];
            i++;
        }

        return sum - (n * (n + 1) / 2);

    }
}
