class Solution {
    public int numIslands(char[][] grid) {
        int numOfIslands=0;
        int row=grid.length;
        int col=grid[0].length;

        int[][] visited = new int[row][col];

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(visited[i][j] == 0 && grid[i][j]== '1'){
                    dfs(grid,i,j,visited);
                    numOfIslands+=1;
                }
            }
        }

        return numOfIslands;
    }

    public void dfs(char[][] grid, int row,int col, int[][] visited){
        //These will give us top,left,down,right field from matrix when we will add these values to current i and j values
        int rowSize= visited.length;
        int colSize= visited[0].length;

        int[] x= {-1,0,1,0}; 
        int[] y= {0,-1,0,1};

        visited[row][col]=1;

        for(int i=0;i<4;i++){
            int r= row + x[i];
            int c= col + y[i];
            
            if(r>=0 && r<rowSize && c >=0 && c<colSize && visited[r][c] == 0 && grid[r][c]== '1'){
                dfs(grid,r,c,visited);
            }
        }
        
    }
}