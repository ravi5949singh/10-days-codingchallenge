class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] vis = new boolean[rooms.size()];
        dfs(rooms,0,vis);
        for(boolean v : vis){
            if(!v){
                return false;
            }
        }
        return true;
    }
    private static void dfs(List<List<Integer>> rooms,int curr, boolean[]vis){
        vis[curr] = true;
        for(int key : rooms.get(curr)){
            
            if(!vis[key]){
                dfs(rooms,key,vis);
            }
        } 
    }
}