class Solution {
    //Method 1: using dp
    
    // public int lengthOfLIS(int[] nums) { 
    //     int n= nums.length;
    //     int lis = Integer.MIN_VALUE;

    //     if(n==1){
    //         return 1;
    //     }
    //     /*
    //      dp[i] --> Length of strictly longest increasing subsequence till index i
    //      so we can get longest increasing subsquence at any dp cell
    //      */
        
    //     int[] dp= new int[n];
    //     // base case dp[0]=1 , as there isnt any number before this, so lis for 0th index is 1
    //     dp[0]=1;

    //     /*
    //      1. for every dp[i] we will add 1 to previousBestLisFoundSoFar
    //      2. to find previousBestLisFoundSoFar we will look for Lis of every previous numbers which are smaller than current number
    //      i.e nums[j] < nums[i] ---> this gives only incresing subsequences
    //      this will make sure that we will add 1 (as a contribution of current number) in a previousBestLisFoundSoFar to get the longest value
    //      3. While doing this we will always maintain maximumLis so that we can return it at last.
    //      */
    //     for(int i=1; i<n;i++){
    //         int previousBestLisFoundSoFar = 0;

    //         for(int j=i-1; j>=0;j--){
    //             if(nums[j] < nums[i]){
    //                 previousBestLisFoundSoFar = Math.max(previousBestLisFoundSoFar, dp[j]);
    //             }
    //         }
    //         dp[i] = 1 + previousBestLisFoundSoFar;
    //         lis = Math.max(lis, dp[i]);
    //     }

    //     return lis;
    // }

//-----------------------------------------------------------------------------------------------------
    /* Method 2: Binary search(while calculation lower bound)
        Lower bound of number : number either greater than or equal to the target number
        Upper bound of number : number strictly greater than the target number
    */

    /* ThoughtProcess:
        watch strivers video : https://www.youtube.com/watch?v=on2hvxBXJH4
        1. will maintain the Lis list
        2. for every number we will check if there is any lower bound number present in lis list
        3. if present that means current number is smaller than the last number of lis list, so we cannot add new number at the end(as this will break the increasing flow of numbers)
        4. so we will find the index of Lower bound number(i.e just greater than current number)
        5. and will replace new number in place of its lower bound number's index in lis List
        6. and if lower bound number present in lis list, that means we can directly add current number in the lis list, which will keep the increasing flow of numbers.

        Note: got to know from the strivers video, the lis list is only temporary list, that doesnt give exact longest increasing subsequence
    */

    List<Integer> lis=new ArrayList<>();

    public int lengthOfLIS(int[] nums) { 
        lis.add(nums[0]);

        for(int i=1;i<nums.length;i++){
            int lowerBoundIndex = getLowerBoundIndex(nums[i]);

            /* about the if condition: 
             found lower bound of current number i.e number >= current number
             so to keep it increasing we will replace the current number on the index of its lower bound number
            */
            if(lowerBoundIndex != -1){ 
                lis.set(lowerBoundIndex, nums[i]);
            }
            else{
                lis.add(nums[i]);
            }
        }

        return lis.size();
    }

    public int getLowerBoundIndex(int target){
        int start=0;
        int end = lis.size()-1;

        int indexOfLowerBoundNumberOfTargetNumber =-1;

        while(start <= end){
            int mid = start +((end-start)/2);

            if(lis.get(mid) >= target ){
                indexOfLowerBoundNumberOfTargetNumber = mid;
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }

        return indexOfLowerBoundNumberOfTargetNumber;
    }
}