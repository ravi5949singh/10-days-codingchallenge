class Solution {
    public int maxDepth(String s) {
        int currlength = 0;
        int maxlength = 0;
        for(int i = 0;i<s.length();i++){
            
            if(s.charAt(i) == '('){
                currlength++;
                maxlength = Math.max(currlength,maxlength);
            }else if(s.charAt(i) == ')'){
                currlength--;
            }
        }
        return maxlength;
    }
}