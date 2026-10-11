class Solution {
    public int maximumLengthSubstring(String s) {
      int left = 0;
      int maxlength = 0;
      int []count = new int[26];
      for(int right = 0;right<s.length();right++){
        char ch = s.charAt(right);
        count[ch -'a']++;
        while(count[ch - 'a'] > 2){
             count[s.charAt(left) - 'a']--;
                left++;
        }
        maxlength = Math.max(maxlength,right - left +1);
      }
      return maxlength;
    }
}