class Solution {
    public int uniquePaths(int m, int n) {
        /*
        dp[i][j] --> number of unique ways to reach cell [m-1][n-1] from cell [i][j]
    i.e dp[0][0] --> number of unique ways to reach cell [m-1][n-1] from cell [0][0]
        */

        int[][] dp=new int[m][n];

        for(int i=0;i<m ;i++){
            dp[i][n-1]=1;
        }

        for(int j=n-1;j>=0 ;j--){
            dp[m-1][j]=1;
        }

        for(int i=m-2; i>=0; i--){
            for(int j=n-2; j>=0; j--){
                int numberOfWaysWhenMovingDown = dp[i+1][j];
                int numberOfWaysWhenMovingRight = dp[i][j+1];
                dp[i][j]= numberOfWaysWhenMovingDown + numberOfWaysWhenMovingRight;
            }
        }

        return dp[0][0];
    }
}