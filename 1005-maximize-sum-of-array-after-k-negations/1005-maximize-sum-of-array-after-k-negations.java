import java.util.*;

class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        
        Arrays.sort(nums);

        // Negative numbers ko positive banao
        for (int i = 0; i < nums.length && k > 0; i++) {
            if (nums[i] < 0) {
                nums[i] = -nums[i];
                k--;
            }
        }

        // Dobara sort karo
        Arrays.sort(nums);

        // Agar k odd hai to smallest number flip karo
        if (k % 2 == 1) {
            nums[0] = -nums[0];
        }

        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        return sum;
    }
}