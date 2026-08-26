
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> map = new PriorityQueue<>();
        for(int i = 0;i<nums.length;i++){
            map.add(nums[i]);

            if(map.size()>k){
                map.poll();
            }
        }
        return map.peek();
    }
}