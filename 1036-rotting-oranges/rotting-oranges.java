class Pair{
    int row;
    int col;
    int currTime;

    public Pair(int row,int col,int currTime){
        this.row=row;
        this.col=col;
        this.currTime=currTime;
    }
}

class Solution {
    /* Why BFS is used for this question:
    1. As the rotton orange rottons all the neighbouring oranges at same distance.
    2. Also all rotton oranges starts rottoning neighbouring oranges at the same time(so its kind of level order traversal), so we cant use dfs. 
    */
    public int orangesRotting(int[][] grid) {
        int m= grid.length;
        int n= grid[0].length;

        int[][] visited=new int[m][n];
        Queue<Pair> q=new LinkedList<>();
        int freshOranges = 0;
        int rottonOranges = 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j,0));
                    visited[i][j]=2;
                    //rottonOranges +=1;
                }
                else if(grid[i][j]==1){
                    freshOranges +=1;
                }
            }
        }

        //bfs
        int maxTime=0;
        int[] x={1,0,-1,0};
        int[] y={0,1,0,-1};
        while(q.size()>0){
            Pair pair=q.poll();
            int r=pair.row;
            int c=pair.col;
            int time=pair.currTime;

            maxTime=Math.max(maxTime,time);
            for(int k=0;k<4;k++){
                int newX=r+x[k];
                int newY=c+y[k];

                if(newX>=0 && newX<m && newY>=0 && newY<n &&
                    visited[newX][newY]!=2 && grid[newX][newY]==1){
                    q.add(new Pair(newX,newY,time+1));
                    visited[newX][newY]=2;
                    rottonOranges+=1;
                }
            }

        }

        //System.out.println("freshOranges: "+freshOranges);
        //System.out.println("rottonOranges: "+rottonOranges);

        if(freshOranges != rottonOranges)
            return -1;

        return maxTime;
    }
}