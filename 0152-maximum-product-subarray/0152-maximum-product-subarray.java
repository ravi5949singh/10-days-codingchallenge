class Solution {
    public int maxProduct(int[] nums) {
       if(nums == null || nums.length == 0) return 0;
       int maxsofar = nums[0];
       int minsofar = nums[0];
       int result = nums[0];

       for(int i = 1; i<nums.length;i++){
          int curr  = nums[i];
        
        int temp = Math.max(curr,Math.max(maxsofar * curr, minsofar * curr));

        minsofar = Math.min(curr ,Math.min(maxsofar *curr, minsofar * curr));

        maxsofar = temp ;

        result = Math.max(result , maxsofar);
       }

return result;
    }
}