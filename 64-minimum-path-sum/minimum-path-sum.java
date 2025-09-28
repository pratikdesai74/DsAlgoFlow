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
        /* for last column cells , there is only 1 way to move i.e down, as there is no right
        so update current dp cell = down dp cell + current grid value
        this makes sure the current dp cell gets updated with minimum path sum
        */
        for(int i= rows-2; i>=0; i--){
            dp[i][cols-1] = dp[i+1][cols-1] + grid[i][cols-1];
        }

        //2. last row (base case)
        /* for last row cells , there is only 1 way to move i.e right , as there is no down
        so update current dp cell = right dp cell + current grid value
        this makes sure the current dp cell gets updated with minimum path sum
        */
        for(int j= cols-2; j>=0; j--){
            dp[rows-1][j] = dp[rows-1][j+1] + grid[rows-1][j];
        }

        for(int i= rows-2; i>=0; i--){
            for(int j= cols-2; j>=0; j--){
                /* Minimum path sum value of ( right cell and down cell as these are the only 2 ways you can move) + current cell value
                this makes sure the current dp cell gets updated with minimum path sum
                */
                int minPathSumOfDownCell = dp[i+1][j];
                int minPathSumOfRightCell = dp[i][j+1];
                dp[i][j] = Math.min(minPathSumOfDownCell , minPathSumOfRightCell) + grid[i][j]; //grid[i][j] = current cell value in orginal gird matrix
            }
        }

        return dp[0][0];
    }
}