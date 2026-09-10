import java.util.*;

class Solution {
    public List<String> commonChars(String[] words) {
        
        List<String> ans = new ArrayList<>();
        
        int[] minFreq = new int[26];
        
        // First word ki frequency
        for(char ch : words[0].toCharArray()) {
            minFreq[ch - 'a']++;
        }
        
        // Remaining words check karo
        for(int i = 1; i < words.length; i++) {
            
            int[] freq = new int[26];
            
            for(char ch : words[i].toCharArray()) {
                freq[ch - 'a']++;
            }
            
            // Minimum frequency store karo
            for(int j = 0; j < 26; j++) {
                minFreq[j] = Math.min(minFreq[j], freq[j]);
            }
        }
        
        // Answer banao
        for(int i = 0; i < 26; i++) {
            while(minFreq[i] > 0) {
                ans.add(String.valueOf((char)(i + 'a')));
                minFreq[i]--;
            }
        }
        
        return ans;
    }
}