class Solution {
    public int numIslands(char[][] grid) {
        int numOfIslands=0;
        int m=grid.length;
        int n=grid[0].length;

        int[][] visited = new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                /* conditions:
                1. cell should contain '1'
                2. that cell should not be already visited
                */
                if(grid[i][j]== '1' && visited[i][j] == 0){
                    dfs(i,j,m,n,visited,grid);
                    numOfIslands+=1;
                }
            }
        }

        return numOfIslands;
    }

    public void dfs(int i,int j, int m, int n, int[][] visited, char[][] grid){
        // mark it as visited
        visited[i][j]=1;

        /*
        Explore all 4 direction for current cell (i,j) --> top, left,down, right
        These will give us top,left,down,right cell from matrix when we will add these values to current i and j values
        */
        int[] x= {-1,0,1,0}; 
        int[] y= {0,-1,0,1};

        for(int k=0;k<4;k++){
            int newX= i + x[k];
            int newY= j + y[k];
            
            /* conditions:
                1. newX should be greater >= 0 and newX < m(no of rows)
                2. newY should be greater >= 0 and newY < n(no of rows)
                3. cell should contain '1'
                2. that cell should not be already visited

                the conditions 1 and 2 are to avoid array out of bound exception
            */

            if(newX>=0 && newX<m && newY >=0 && newY<n && grid[newX][newY]== '1' && visited[newX][newY] == 0){
                dfs(newX,newY,m,n,visited,grid);
            }
        }
        
    }
}