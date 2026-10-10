class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
               return Math.max(
            maxSum(nums, firstLen, secondLen),
            maxSum(nums, secondLen, firstLen)
        );
 
    }
    private int maxSum(int nums[], int L, int M){
        int sumL = 0;
        int sumM= 0;
      for(int i = 0;i<L;i++){
        sumL+=nums[i];
      }
      for(int i = L;i<L+M;i++){
        sumM+=nums[i];
      }
      int maxL = sumL;
        int ans = sumL + sumM;

        for (int i = L + M; i < nums.length; i++) {
            sumL += nums[i - M] - nums[i - M - L];
            maxL = Math.max(maxL, sumL);

            sumM += nums[i] - nums[i - M];

            ans = Math.max(ans, maxL + sumM);
        }

        return ans;
    }
}