class Solution {
    public String frequencySort(String s) {

       HashMap<Character,Integer> map = new HashMap<>();
       for(int i = 0;i<s.length();i++){
        char ch = s.charAt(i);
        map.put(ch,map.getOrDefault(ch,0)+1);
       }
       ArrayList<Character> list = new ArrayList<>(map.keySet());
       Collections.sort(list,(a,b)->map.get(b) - map.get(a));
       StringBuilder ans = new StringBuilder();
       for(char  ch : list){
        int count = map.get(ch);
        while(count -->0){
            ans.append(ch);
        }
       }
       return ans.toString();

    }
}