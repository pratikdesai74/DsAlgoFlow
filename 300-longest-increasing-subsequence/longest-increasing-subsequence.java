class Solution {
    //Method 1: using dp
    public int lengthOfLIS(int[] nums) { 
        int n= nums.length;
        int lis = Integer.MIN_VALUE;

        if(n==1){
            return 1;
        }
        /*
         dp[i] --> Length of strictly longest increasing subsequence till index i
         so we can get longest increasing subsquence at any dp cell
         */
        
        int[] dp= new int[n];
        dp[0]=1;

        for(int i=1; i<n;i++){
            int previousBestLisFoundSoFar = 0;

            for(int j=i-1; j>=0;j--){
                if(nums[j] < nums[i]){
                    previousBestLisFoundSoFar = Math.max(previousBestLisFoundSoFar, dp[j]);
                }
            }
            dp[i] = 1 + previousBestLisFoundSoFar;
            lis = Math.max(lis, dp[i]);
        }

        return lis;
    }

}