class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
       int totalsum =0;
       for(int i = 0;i<arr.length;i++){
        totalsum+=arr[i];
       }
       if(totalsum % 3 !=0){
        return false;
       }
       int targetsum = totalsum /3;
       int currsum = 0;
       int count =0;
       for(int i = 0;i<arr.length;i++){
        currsum+=arr[i];
        if(currsum == targetsum){
            currsum= 0;
            count++;
        }
       }
       return count>=3;
        
    }
}