import java.util.*;

class Solution {
    public List<String> commonChars(String[] words) {
        List<String> ans = new ArrayList<>();
       int comm[] = new int[26];
       for(int j =0;j<words[0].length();j++){
        char ch = words[0].charAt(j);
        comm[ch-'a']++;
       }
       for(int i = 0;i<words.length;i++){
        int curr[] = new int[26];
        for(int j =0;j<words[i].length();j++){
            char ch = words[i].charAt(j);
            curr[ch -'a']++;
        }
         for(int k =0;k<26;k++){
        comm[k] = Math.min(comm[k],curr[k]); 
       }
       }
      
       for(int i = 0;i<26;i++){
        while(comm[i]>0){
            char ch = (char)(i+'a');
            ans.add(String.valueOf(ch));
            comm[i]--;
        }

       }
       return ans;
    }
}