class Solution {
    public Map<String, Set<Integer>> connectionsAllowed = Map.of(
    "U", Set.of(2, 3, 4),
    "D", Set.of(2, 5, 6),
    "L", Set.of(1, 4, 6),
    "R", Set.of(1, 3, 5));
    public boolean hasValidPath(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        int[][] visited= new int[m][n];
        return dfs(0,0,m,n,visited,grid);
    }

    public boolean dfs(int i,int j,int m,int n,int[][] visited,int[][] grid){
        visited[i][j]=1;
        if(i==m-1 && j==n-1)
            return true;

        if(i<0 || i>m-1 || j<0 || j>n-1)
            return false;

        if(grid[i][j]==1){
            if(j>0 && connectionsAllowed.get("L").contains(grid[i][j-1]) && visited[i][j-1]==0)
                if(dfs(i,j-1,m,n,visited,grid)) return true;
            if(j<n-1 && connectionsAllowed.get("R").contains(grid[i][j+1]) && visited[i][j+1]==0)
                if(dfs(i,j+1,m,n,visited,grid)) return true;   
        }
        else if(grid[i][j]==2){
            if(i>0 && connectionsAllowed.get("U").contains(grid[i-1][j]) && visited[i-1][j]==0)
                if(dfs(i-1,j,m,n,visited,grid)) return true;
            if(i<m-1 && connectionsAllowed.get("D").contains(grid[i+1][j]) && visited[i+1][j]==0)
                if(dfs(i+1,j,m,n,visited,grid)) return true;   
        }
        else if(grid[i][j]==3){
            if(j>0 && connectionsAllowed.get("L").contains(grid[i][j-1]) && visited[i][j-1]==0)
                if(dfs(i,j-1,m,n,visited,grid)) return true;
            if(i<m-1 && connectionsAllowed.get("D").contains(grid[i+1][j]) && visited[i+1][j]==0)
                if(dfs(i+1,j,m,n,visited,grid)) return true;
        }
        else if(grid[i][j]==4){
            if(j<n-1 && connectionsAllowed.get("R").contains(grid[i][j+1]) && visited[i][j+1]==0)
                if(dfs(i,j+1,m,n,visited,grid)) return true;
            if(i<m-1 && connectionsAllowed.get("D").contains(grid[i+1][j]) && visited[i+1][j]==0)
                if(dfs(i+1,j,m,n,visited,grid)) return true;
        }
        else if(grid[i][j]==5){
            if(j>0 && connectionsAllowed.get("L").contains(grid[i][j-1]) && visited[i][j-1]==0)
                if(dfs(i,j-1,m,n,visited,grid)) return true;
            if(i>0 && connectionsAllowed.get("U").contains(grid[i-1][j]) && visited[i-1][j]==0)
                if(dfs(i-1,j,m,n,visited,grid)) return true;
        }
        else if(grid[i][j]==6){
            if(j<n-1 && connectionsAllowed.get("R").contains(grid[i][j+1]) && visited[i][j+1]==0)
                if(dfs(i,j+1,m,n,visited,grid)) return true;
            if(i>0 && connectionsAllowed.get("U").contains(grid[i-1][j]) && visited[i-1][j]==0)
                if(dfs(i-1,j,m,n,visited,grid)) return true; 
        }

        return false;
    }
}