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
    /* Why BFS is used for this question: Watch Strivers video on youtube
    1. As the rotton orange rottons all the neighbouring oranges at same distance.
    2. Also all rotton oranges starts rottoning neighbouring oranges at the same time(so its kind of level order traversal), so we cant use dfs. 
    3. Whenever its asked to check the shortest distance, shortest path, minimum time .. such words always think
    of BFS.
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
                }
                else if(grid[i][j]==1){
                    freshOranges +=1;
                }
            }
        }

        //Regular BFS
        int maxTime=0;
        int[] x={1,0,-1,0};
        int[] y={0,1,0,-1};
        while(q.size()>0){
            //Fetch first from the que
            Pair pair=q.poll();
            int r=pair.row;
            int c=pair.col;
            int time=pair.currTime;

            /*
                We will maintain maximum time requred to rotton the oranges as many oranges can be rotton simultaniously.
                Also that is the reason to use Pair --> which helds the cells row and column and current time.

                i.e in example 1, 
                step 2 : 
                2 oranges = (0,1) and (1,0) gets rotton simultanious
                so will add (0,1,1) and (1,0,1) in the queue

                step 3 :
                for (0,1,1) orange ---> right side and down oranges can be rotton so we can add them in queue
                so will add (0,2,1+1) and (1,1,1+1) in queue

                not in the question: but even if there was any orange down to the (1,0,1) , That would have been rotton
                as part of step 3 and we would have added (2,0,1+1) in the queue. (please watch how we have considered the time)

            */
            maxTime=Math.max(maxTime,time);

            /*
                We will check all the neighbouring oranges(in all 4 directions)
                
                Conditions to check for adding neighbouring oranges into queue
                1. Checks to avoid out of bound exception
                2. If its not visited (visited[newX][newY]!=2) i.e its not rotton already
                3. That orange is fresh (Then only we can rotton it)

                For Valid Oranges:
                1. We will add them in the queue with (row,col, time+1)
                2. also mark them visited/rotton in visited array and increase the rottonOranges count
            */
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

        //If all the fresh oranges present earlier are not converted to rotton then return -1
        if(freshOranges != rottonOranges)
            return -1;

        return maxTime;
    }
}