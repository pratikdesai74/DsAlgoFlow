class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        /*
        dp[i][j] --> number of path to reach [m-1][n-1] cell from [i][j] cell
    i.e dp[0][0] --> number of path to reach [m-1][n-1] cell from [0][0] cell    
        */
        int rows= obstacleGrid.length;
        int cols=obstacleGrid[0].length;

        int[][] dp=new int[rows][cols];
        
        if(obstacleGrid[0][0]==1 || obstacleGrid[rows-1][cols-1]==1)
            return 0;

        // filling the last column as base condition
        for(int i=rows-1; i>=0; i--){
            if(obstacleGrid[i][cols-1] ==1){
            /*    
             when we found the obstacle, make every cell from that cell to its top as 0, because all the cells from that cell to its top of it, wont be able to traverse to the destination cell
            */ 
                break;
            }
            else{
                dp[i][cols-1]=1;
            }    
        }

        // filling the last row as base condition
        for(int j=cols-1; j>=0; j--){
            if(obstacleGrid[rows-1][j] ==1){
                /*    
             when we found the obstacle, make every cell from that cell to its left as 0, because all the cells from that cell to left of it, wont be able to traverse to the destination cell
            */ 
                break;
            }
            else{
                dp[rows-1][j]=1;
            }       
        }


        for(int i=rows-2; i>=0; i--){
            for(int j=cols-2; j>=0; j--){
                if(obstacleGrid[i][j] !=1){ // current cell is not having obstacle 
                    dp[i][j]= dp[i+1][j] + dp[i][j+1];
                }
                else{
                   dp[i][j]=0; // current cell is having obstacle 
                }
            }
        }

        return dp[0][0];
    }
}