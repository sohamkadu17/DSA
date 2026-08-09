// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/

import java.util.ArrayList;
import java.util.List;

public class NumbersDisappeared {
    public static void main(String[] args) {
        int arr[] = {4,3,2,7,8,2,3,1};
        List<Integer> ans = new ArrayList<>();
        ans = findDisappearedNumbers(arr);
        System.out.println("Sorted Array is :"+ans );
    }


    static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != i + 1) {
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            } else {
                i++;
            }
        }
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                ans.add(j);
            }
        }
        return ans;
    }
}
