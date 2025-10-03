class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m= dungeon.length; //rows
        int n= dungeon[0].length; // colomns

        /*
        dp[i][j] --> minimum number of health of knight require to reach princess at cell [m][n] from cell [i][j]
        dp[0][0] --> minimum number of health of knight require to reach princess at cell [m][n] from cell [0][0]
        */

        int[][] dp=new int[m][n];

        if(dungeon[m-1][n-1] < 0){
            dp[m-1][n-1]= 1 - dungeon[m-1][n-1];
        }
        else{
            dp[m-1][n-1] = 1;
        }
        //dp[m-1][n-1] = 1 - dungeon[m-1][n-1];

        //base case : last row
        for(int j=n-2; j>=0; j--){
            int minimumHealthRequireToEnterThisCell = dp[m-1][j+1] - dungeon[m-1][j];
            dp[m-1][j] = minimumHealthRequireToEnterThisCell >0 ? minimumHealthRequireToEnterThisCell: 1;
        }

        //base case : last colomn
        for(int i=m-2; i>=0; i--){
            int minimumHealthRequireToEnterThisCell = dp[i+1][n-1] - dungeon[i][n-1];
            dp[i][n-1]= minimumHealthRequireToEnterThisCell >0 ? minimumHealthRequireToEnterThisCell: 1;
        }

        for(int i=m-2; i>=0; i--){
            for(int j=n-2; j>=0; j--){
                int rightCell= dp[i][j+1];
                int downCell= dp[i+1][j];

                int minimumHealthRequireToEnterThisCellExcludingCurrentCellNumber = Math.min(rightCell, downCell);
                
                int minimumHealthRequireToEnterThisCell = minimumHealthRequireToEnterThisCellExcludingCurrentCellNumber - dungeon[i][j];

                dp[i][j] = minimumHealthRequireToEnterThisCell >0 ? minimumHealthRequireToEnterThisCell: 1;
            }
        }

        return dp[0][0];
    }
}