class Solution {
    public boolean wordPattern(String pattern, String s) {
        String []words = s.split(" ");
        if(pattern.length() != words.length){
            return false;
        }
        int n = pattern.length();
        for(int i = 0;i<n;i++){
            for(int j = i+1;j<n;j++){
                if(pattern.charAt(i) == pattern.charAt(j)){
                    if(!words[i].equals(words[j])){
                        return false;
                    }
                }else{
                     if(words[i].equals(words[j])){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}