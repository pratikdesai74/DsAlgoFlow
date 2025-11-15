class Pair{
    int row;
    int col;
    int distance;

    public Pair(int row,int col, int distance){
        this.row=row;
        this.col=col;
        this.distance=distance;
    }

}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m= mat.length;
        int n= mat[0].length;
        
        int[][] ans=new int[m][n];
        
        for(int[] row: ans)
            Arrays.fill(row, Integer.MAX_VALUE);
        
        int[][] visited = new int[m][n];
        Queue<Pair> q=new LinkedList<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    visited[i][j]= 1;
                    q.add(new Pair(i,j,0));
                }
            }
        }
        //bfs
        while(q.size()>0){
            Pair pair= q.poll();
            int i=pair.row;
            int j=pair.col;
            int dis= pair.distance;

            
            ans[i][j]=Math.min(ans[i][j],dis);

            int[] x={-1,0,1,0};
            int[] y={0,-1,0,1};
            

            for(int k=0;k<4;k++){
                int newX= i+x[k];
                int newY= j+y[k];

                if(newX>=0 && newX<m && newY>=0 && newY<n 
                && visited[newX][newY]==0){
                    visited[i][j]= 1;
                    q.add(new Pair(newX,newY,dis+1));
                }
            }
        }

        return ans;
    }
}