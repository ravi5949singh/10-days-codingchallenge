class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
       int oldcolor = image[sr][sc];
       if(oldcolor  == color){
        return image;
       }
       dfs(image ,sr,sc,oldcolor,color);
       return image;
    }
    private static void dfs(int[][]image , int row, int col , int oldcolor , int newcolor){
        if(row<0 || row >= image.length || col <0 || col >=image[0].length){
            return;
        }
        if(image[row][col] != oldcolor){
            return;
        }
        image[row][col] = newcolor;

        dfs(image , row-1,col,oldcolor,newcolor);
           dfs(image , row+1,col,oldcolor,newcolor);
              dfs(image , row,col-1,oldcolor,newcolor);
                 dfs(image , row,col+1,oldcolor,newcolor);
    }
}