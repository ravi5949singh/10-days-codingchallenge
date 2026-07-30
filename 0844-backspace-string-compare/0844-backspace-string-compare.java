class Solution {
    public boolean backspaceCompare(String s, String t) {
        return bold(s).equals(bold(t));
    }
    private  String bold(String str){
  Stack<Character> st = new Stack<>();
  for(char ch : str.toCharArray()){
    if(ch != '#'){
        st.push(ch);
    }else if(!st.isEmpty()){
        st.pop();
    }
  }
  StringBuilder  ans = new StringBuilder();
  while(!st.isEmpty()){
    ans.append(st.pop());
  }
  return ans.reverse().toString();
    }
}