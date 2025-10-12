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
        // base case dp[0]=1 , as there isnt any number before this, so lis for 0th index is 1
        dp[0]=1;

        /*
         1. for every dp[i] we will add 1 to previousBestLisFoundSoFar
         2. to find previousBestLisFoundSoFar we will look for Lis of every previous numbers which are smaller than current number
         i.e nums[j] < nums[i] ---> this gives only incresing subsequences
         this will make sure that we will add 1 (as a contribution of current number) in a previousBestLisFoundSoFar to get the longest value
         3. While doing this we will always maintain maximumLis so that we can return it at last.
         */
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