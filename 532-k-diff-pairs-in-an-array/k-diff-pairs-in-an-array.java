class Solution {
    public int findPairs(int[] nums, int k) {
        
        Arrays.sort(nums);

        int left=0,right=1;
        int uniquePairCount=0;
        int n=nums.length;

        while(left<n && right<n){
            int diff=nums[right]-nums[left];

            if(left==right || diff<k){
                right+=1;
            }
            else if(diff>k){
                left+=1;
            }
            else{
                uniquePairCount+=1;
                left+=1;
                right+=1;

                //skipping the duplicates
                while(right<n && nums[right]==nums[right-1]){
                    right+=1;
                }
            }
        }

        return uniquePairCount;
    }
}