/*
 Same as no of islands, only instead of counting islands, we will maintain a counter for area of each island and
 return maximum area
*/
class Solution {
    public static int area=0;
    public int maxAreaOfIsland(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        int[][] visited = new int[m][n];
        int maxArea=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && visited[i][j]==0){
                    area=0;
                    dfs(i, j,m, n, grid, visited);
                    // System.out.println("area: "+area);
                    maxArea=Math.max(maxArea,area);
                }
            }
        }

        return maxArea;
    }

    public void dfs(int i,int j,int m,int n, int[][] grid,int[][] visited){
        visited[i][j]=1;
        area+=1;

        int[] x={-1,0,1,0};
        int[] y={0,-1,0,1};
        
        for(int k=0;k<4;k++){
            int newX=i+x[k];
            int newY=j+y[k];

            if(newX>=0 && newX <m && newY>=0 && newY<n &&
            grid[newX][newY]==1 && visited[newX][newY]==0){
                dfs(newX, newY, m, n, grid, visited);
            }
        }
    }
}