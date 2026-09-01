class Solution {
public:
    int findJudge(int n, vector<vector<int>>& trust) {
        vector<vector<int>>adj(n,vector<int>(0));
        for(auto v:trust){
            adj[v[1]-1].push_back(v[0]);
        }
        int judge=-1;
        for(int i=0;i<n;i++){
            vector<int>v=adj[i];
            if(v.size()==n-1) judge=i;
        }

        if(judge==-1) return -1;
        for(auto v:trust){
            if(v[0]==judge+1) return -1;
        }
        return judge+1;
    }
};