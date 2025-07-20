class Solution {
    public int findPairs(int[] nums, int k) {
        
        Arrays.sort(nums);

        int left=0,right=1;
        int uniquePairCount=0;
        int n=nums.length;

        while(left<n && right<n){
            int diff=nums[right]-nums[left];

            if(left==right || diff<k){
                right++;
            }
            else if(diff>k){
                left++;
            }
            else{
                uniquePairCount++;
                left++;
                right++;

                //skipping the duplicates
                while(right<n && nums[right]==nums[right-1]){
                    right++;
                }
            }
        }

        return uniquePairCount;
    }
}