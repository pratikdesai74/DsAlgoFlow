class Solution {
    // 1. DP - Memoization
    // public int fib(int n) {
    //     int[] dp=new int[n+1];
    //     for(int i=0;i<=n;i++)
    //         dp[i]=-1;

    //     return helper(n,dp);  
    // }

    // public int helper(int n,int[] dp){
    //     if(n <= 1)
    //         return n;

    //     if(dp[n] != -1)
    //         return dp[n];


    //     return dp[n]=helper(n-1,dp) + helper(n-2,dp);       
    // }

    //2. DP - Tabulation(real dp)
    // public int fib(int n) {
    //     int[] dp=new int[n+1];

    //     for(int i=0;i<=n;i++){
    //         if(i==0 || i==1)
    //             dp[i]=i;
    //         else    
    //             dp[i]=dp[i-1]+dp[i-2];
    //     }

    //     return dp[n];  
    // }

    //3. DP - State optimised(space optimised) - compitative programming
    public int fib(int n) {
        if(n<=1)
            return n;

        int prev =1;
        int prev2prev=0;
        int curr=0;

        for(int i=2;i<=n;i++){    
            curr=prev + prev2prev;
            prev2prev = prev;
            prev = curr;
        }

        return prev;  
    }
}