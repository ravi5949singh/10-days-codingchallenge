class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() +s2.length() != s3.length()){
            return false;
        }
        Boolean[][] memo = new Boolean[s1.length() + 1][s2.length() + 1];
    return solve(s1,s2,s3,0,0,0,memo);
    }
    private static boolean solve(String s1,String s2,String s3 , int i ,int j ,int k,Boolean[][] memo){
        if(k == s3.length()){
            return true;
        }
        if (memo[i][j] != null) { return memo[i][j]; }
        boolean takes1 = false;
        boolean takes2 = false;
        if(i<s1.length() && s1.charAt(i) == s3.charAt(k)){
            takes1 = solve(s1,s2,s3,i+1,j,k+1,memo);
        }
        if(j<s2.length() && s2.charAt(j) == s3.charAt(k)){
            takes2 = solve(s1,s2,s3,i,j+1,k+1,memo);
        }
       memo[i][j] = takes1 || takes2; 
       return memo[i][j];
    }
}