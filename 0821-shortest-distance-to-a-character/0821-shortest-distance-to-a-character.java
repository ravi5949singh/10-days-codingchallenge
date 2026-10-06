class Solution {
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int arr[] = new int[n];
        int dist = n;
        for(int i =0;i<n;i++){
            if(s.charAt(i) == c){
                dist =0;
            }else{
                dist++;
            }
            arr[i] = dist;
        }
        for(int i = n-1;i>=0;i--){
            if(s.charAt(i) == c){
                dist=0;
            }else{
                dist++;
            }
            arr[i] = Math.min(arr[i],dist);
        }
        return arr;
    }
}