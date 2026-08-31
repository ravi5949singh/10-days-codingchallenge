class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
      
  HashMap<Integer,Integer> map = new HashMap<>();
  for(int i = 0;i<deck.length;i++){
    map.put(deck[i] ,map.getOrDefault(deck[i],0)+1);
  }
         int g = 0;
         for(int freq : map.values()){
            g = gcd(g,freq);

         
  }
  return g>=2;
    
    }
    private static int gcd(int a, int b){
    while(b !=0){
        int rem = a%b;
       a=b;
       b= rem;
    }
      return a;
  }

}