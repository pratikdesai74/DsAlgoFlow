/*  same question as No of islands
    1. create adjecency list
    2. start dfs from node 0
    3. mark each visited node as visisted(1)
    4. start new dfs from remaining unvisited nodes and increment counter once done with every dfs call from main function

*/

class Solution {
    public int findCircleNum(int[][] isConnected) {
        //adList
        int n=isConnected.length;
        List<List<Integer>> adList= new ArrayList<>();
        for(int i=0;i<n;i++)
            adList.add(new ArrayList<>());

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1)
                    adList.get(i).add(j);
            }
        }

        int[] visited= new int[n];
        int numberOfProvinces=0;

        for(int node=0;node<n;node++){
            if(visited[node]==0){
                dfs(node,adList,visited);
                numberOfProvinces++;
            }
        }

        return numberOfProvinces;
    }

    public void dfs(int node,List<List<Integer>> adList, int[] visited){
        visited[node]=1;
        for(int neighbourNode: adList.get(node)){
            if(visited[neighbourNode]==0){
                dfs(neighbourNode,adList,visited);
            }
        }
    }
}