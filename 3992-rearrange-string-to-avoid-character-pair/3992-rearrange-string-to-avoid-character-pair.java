class Solution {
    public String rearrangeString(String s, char x, char y) {
       StringBuilder ans = new StringBuilder();
       for(int i = 0;i<s.length();i++){
          char ch = s.charAt(i);
          if(ch == y){
            ans.append(ch);
          }
       }
         for(int i = 0;i<s.length();i++){
          char ch = s.charAt(i);
          if(ch != y){
            ans.append(ch);
          }
       }
       return ans.toString();
    }
}