class Solution {
    public int findCircleNum(int[][] isConnected) {
      int n = isConnected.length;
      int count=0;
      boolean [] vis = new boolean[n];

      for(int i = 0;i<n;i++){
        if(!vis[i]){
            dfs(isConnected,i,vis);
            count++;
        }
      }
return count;

    }
    private  void dfs(int[][]graph , int src , boolean[] vis){
        vis[src] = true;
        for(int j = 0;j<graph.length;j++){
            if(!vis[j] &&graph[src][j] == 1 ){
                dfs(graph ,j , vis);
            }
        }
    }
}