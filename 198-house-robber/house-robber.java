class Solution {
    public int rob(int[] nums) {
        /*
        dp[i] : max amount of money that the robber can rob till i-th index
        */
        int n=nums.length;
        int[]dp = new int[n];
        
        if(n==1)
            return nums[0];

        dp[0]=nums[0];
        dp[1]= Math.max(dp[0],nums[1]);    

        for(int i=2; i<n; i++){
            /*
            There are 2 cases: either we can pick amount at current ith index or we notPick
            if pick : the total amount would be current value from nums + previous to previous value from dp (becasue if we pick amount from current index house we cannot rob adjesent house)

            in case of notPick: we can consider previos index dp value (as we arent considering value from current house, we can consider adjesent house amount)

            and we are storing max(pick and notPick) as we need to maximise the robbery amount
            */
            int pick = nums[i] + dp[i-2];
            int notPick = dp[i-1];
            dp[i]= Math.max(pick, notPick);
        }

        return dp[n-1];
    }
}