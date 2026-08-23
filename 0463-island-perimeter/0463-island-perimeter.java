class Solution {
    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];

        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j] == 1){
                   return dfs(grid,i,j,vis);
                }
            }
        }
        return 0;

    }
    private static int dfs(int[][]graph, int row, int col , boolean[][]vis){
        if(row<0 || row >= graph.length || col < 0 || col >=graph[0].length){
            return 1 ;
        }
      if(graph[row][col] == 0){
        return 1;
      }
      if(vis[row][col]){
        return 0;
      }
      vis[row][col] = true;

      int peri = 0;

      peri+=dfs(graph,row-1,col,vis);
       peri+=dfs(graph,row+1,col,vis);
        peri+=dfs(graph,row,col-1,vis);
         peri+=dfs(graph,row,col+1,vis);

         return peri;
 
    }
}