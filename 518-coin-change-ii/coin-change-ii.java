class Solution {
    public int change(int amount, int[] coins) {

        //dp[i][j] : no. of combinations / ways of using upto i coins (or upto the ith coin) to make amount j
        
        int n = coins.length;
        int dp[][] = new int[n+1][amount+1];

        /* 0th row denotes 0 coins, there are 0 ways to use 0 coins to make amount j, so 0th row will always
         be 0, array is already initialized to 0 so no need to separately fill */

        /* 0th column denotes number of ways to make amount 0 using i coins, which will always be 1 i.e.     
        there is always 1 way to make 0 amount */ 
        for(int i=0; i<n+1; i++)
        {
            dp[i][0] = 1;
        }

        for(int i=1; i<n+1; i++)
        {
            for(int j=1; j<amount+1; j++)
            {
                //coins > amount not pick
                if(coins[i-1] > j)
                {
                    dp[i][j] = dp[i-1][j];
                }
                else //coins <= amount pick
                {
                    int pick = dp[i][j - coins[i-1]];
                    int notPick = dp[i-1][j];

                    dp[i][j] = pick + notPick;
                }
            }
        }

        return dp[n][amount];

    }
}