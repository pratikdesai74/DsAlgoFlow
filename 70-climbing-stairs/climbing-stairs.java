class Solution {
    public int climbStairs(int n) {
        //1. Tabulation TC -> O(N) & SC ->O(N)
        //dp[i] --> number of ways to reach to the top, when there are i number of stairs
        // dp[n] would give us the answer

        // int [] dp=new int[n+1];
        // //In combinatorics, "doing nothing" represents the single, unique way
        // dp[0]=1;
        // dp[1]=1;

        // for(int i=2; i<=n; i++){
        //     dp[i]=dp[i-1]+dp[i-2];
        // }

        // return dp[n];

//----------------------------------------------------------------------------------------
        //2. state Optimization TC -> O(N) & SC ->O(1)
        //dp[i] --> number of ways to reach to the top, when there are i number of stairs
        // its inhansed version of tabulation, where we take 3 variables(prev2prev, prev, curr) and prev would give us the answer
        
        //In combinatorics, "doing nothing" represents the single, unique way
        int prev2prev=1;
        int prev=1;

        for(int i=2; i<=n; i++){
            int curr = prev2prev + prev;
            prev2prev = prev;
            prev = curr;
        }

        return prev;
    }
}