class Solution {
    // //DP - Memoization
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

    //DP - Tabulation(real dp)
    public int fib(int n) {
        int[] dp=new int[n+1];

        for(int i=0;i<=n;i++){
            if(i==0 || i==1)
                dp[i]=i;
            else    
                dp[i]=dp[i-1]+dp[i-2];
        }

        return dp[n];  
    }
}