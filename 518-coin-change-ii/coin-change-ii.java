class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[][] dp=new int[n+1][amount+1];

        for(int i=1;i<=n ;i++){
            dp[i][0]=1;
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=amount; j++){
                
                if(coins[i-1] <= j){
                    int pick= dp[i][j-coins[i-1]];
                    int notPick= dp[i-1][j];

                    dp[i][j]= pick+notPick; // total combinations = combinations if we pick current coin + combinations if we notPick current coin

                }
                else
                {
                    int notPick= dp[i-1][j];
                    dp[i][j]= notPick;
                }
            }
        }


        return dp[n][amount];
    }
}