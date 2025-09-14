class Solution {
    public int coinChange(int[] coins, int amount) {

        /* 2 changing parameters i.e. coins and amount so 2D array
        dp[i][j] = fewest number of coins using upto 'i' coins (i.e using coins upto ith coin) required to 
        make amount j
        e.g. Coins array is [1,2,5] then i could be 0, 1, 2 or 3 i.e. upto length of coins array + 1
        Since we have to consider base case of 0 coins.
        Similarly, amount is 11 then j could go from 0, 1, 2 ... 11 i.e. upto total amount
        Since we have to consider base case of 0 amount.
        The dp array will start from dp[0][0] and our answer will lie at dp[3][11] so array size is n+1, 
        amount+1 */

        int n = coins.length;
        int dp[][] = new int[n+1][amount+1];

        /* If coins are 0, then we will need infinite coins to make amount j
        using 1e9 instead of int_max as using int_max will cause overflow on line 38. Else use int_max - 1*/
        for(int j=1; j<amount+1; j++)
        {
            dp[0][j] = (int)1e9;
        }

        /* since our array is already initialized to 0, no need to fill column '0' with 0.
           column 0 denotes 0 amount, so for 0 amount we will need 0 coins of any i type. */
        
        for(int i=1; i<n+1; i++)
        {
            for(int j=1; j<amount+1; j++)
            {
                //if coin > amount i.e. don't pick
                if(coins[i-1] > j)
                {
                    dp[i][j] = dp[i-1][j];         
                }
                else // coin <= amount i.e. pick
                {
                    //notPick : if we not pick current coin, we can consider previous coins (i-1) frequency for the same amount(j)
                    //pick : we will add 1 frequency of current coint + whatever amount is remaining (amount - current coin)
                    // i.e the coin remain(i) same only amount is changes(j-coins[i-1])
                    int pick = 1 + dp[i][j - coins[i-1]];
                    int notPick = dp[i-1][j];
                    dp[i][j] = Math.min(pick, notPick);
                }
            }

        }
    
    int ans = dp[n][amount];
    if(ans >= (int)1e9) // or use int_max - 1
        return -1;
    return ans;
    }
}