class Pair{
    int row;
    int col;
    int steps;

    public Pair(int row,int col,int steps){
        this.row=row;
        this.col=col;
        this.steps=steps;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        int[][] visited =new int[m][n];
        Queue<int[]> q= new LinkedList<>();

        if(grid[0][0]==1 || grid[m-1][n-1]==1)
            return -1;
            
        q.add(new int[]{0,0,1});
        visited[0][0]=1;

        //regular bfs

        while(q.size()>0){
            int[] arr=q.poll();
            int i=arr[0];
            int j=arr[1];
            int steps=arr[2];

            //System.out.println("i:"+i+" j:"+j+" :: steps: "+steps);
            if(i==m-1 && j==n-1)
                return steps;

            int[] x={-1,0,1,0,-1,1,1,-1};
            int[] y={0,-1,0,1,-1,1,-1,1};

            for(int k=0;k<8;k++){
                int newX=i+x[k];
                int newY=j+y[k];

                if(newX>=0 && newX<m && newY>=0 && newY<n
                 && visited[newX][newY]==0 && grid[newX][newY]==0){
                    visited[newX][newY]=1;
                    q.add(new int[]{newX, newY,steps+1});
                 }
            }
        }

        return -1;
    }
}