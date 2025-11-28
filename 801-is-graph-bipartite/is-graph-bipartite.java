//watch strivers video
class Solution {
    public boolean isBipartite(int[][] graph) {
        int n= graph.length;
        int[] colored=new int[n];
        Arrays.fill(colored,-1);

        for(int i=0;i<n;i++){
            if(colored[i]== -1 && check(i,graph,colored)== false)
                return false;
        }

        return true;
    }

    public boolean check(int start,int[][] graph,int[] colored){
        colored[start]=0;
        Queue<Integer> q=new LinkedList<>();
        q.add(start);

        while(q.size()>0){
            int node= q.poll();

            for(int neighbourNode : graph[node]){
                if(colored[neighbourNode]== -1){
                    colored[neighbourNode]= 1 - colored[node];
                    q.add(neighbourNode);
                }
                else if(colored[neighbourNode] == colored[node]){
                    return false;
                }
            }
        }

        return true;
    }
}