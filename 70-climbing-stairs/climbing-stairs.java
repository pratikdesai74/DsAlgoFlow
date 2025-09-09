class Solution {
    public int climbStairs(int n) {
        //dp[i] --> number of ways to reach to the top, when there are i number of stairs
        // dp[n] would give us the answer

        int [] dp=new int[n+1];
        //In combinatorics, "doing nothing" represents the single, unique way
        dp[0]=1;
        dp[1]=1;

        for(int i=2; i<=n; i++){
            dp[i]=dp[i-1]+dp[i-2];
        }

        return dp[n];
    }
}