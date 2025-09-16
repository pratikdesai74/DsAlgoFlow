class Solution {
    public int minPathSum(int[][] grid) {
        /*
        dp[i][j] --> will give minimum sum of numbers from cell[i][j] to reach cell[m-1][n-1]
    i.e dp[0][0] --> will give minimum sum of numbers from cell[0][0] to reach cell[m-1][n-1]  
        */
        int rows= grid.length;
        int cols= grid[0].length;

        int[][] dp=new int[rows][cols];

        dp[rows-1][cols-1]=grid[rows-1][cols-1];
        //Filling base cases
        //1. last column (base case)
        for(int i= rows-2; i>=0; i--){
            dp[i][cols-1] = dp[i+1][cols-1] + grid[i][cols-1];
        }

        //2. last row (base case)
        for(int j= cols-2; j>=0; j--){
            dp[rows-1][j] = dp[rows-1][j+1] + grid[rows-1][j];
        }

        for(int i= rows-2; i>=0; i--){
            for(int j= cols-2; j>=0; j--){
                dp[i][j] = Math.min(dp[i+1][j] , dp[i][j+1]) + grid[i][j];
            }
        }

        return dp[0][0];
    }
}