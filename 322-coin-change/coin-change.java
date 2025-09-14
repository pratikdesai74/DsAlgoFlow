class Solution {
    public int coinChange(int[] coins, int amount) {
        int noOfCoins=coins.length;

        int[][] dp=new int[noOfCoins + 1][amount + 1];

        for(int col=1;col<=amount; col++){
            dp[0][col]=Integer.MAX_VALUE -1 ; // to avoid overflow as while picking we would add +1 to this value
        }

        for(int row=1; row<=noOfCoins; row++){
            for(int col=1; col<=amount; col++){
                int pick=0;
                int notPick=0;

                if(coins[row-1]<=col){
                    //include current coin or dont include
                    pick= 1 + dp[row][col- coins[row-1]];
                    // 1:: adding only one coint of current value
                    //dp[row][col- coins[row-1]] :: 
                    notPick=dp[row-1][col];
                    dp[row][col]= Math.min(pick,notPick);
                }
                else{
                    dp[row][col]=dp[row-1][col];
                }
                
            }
        }

        return dp[noOfCoins][amount] == Integer.MAX_VALUE -1 ? -1 : dp[noOfCoins][amount];
    }
}