class Solution {
    List<Integer> lIS = new ArrayList<>();

    public int lengthOfLIS(int[] nums) { 
        lIS.add(nums[0]);

        for(int i=1;i<nums.length;i++){
            int lowerBoundIndex =getLowerBoundIndex(nums[i]);
            if( lowerBoundIndex != -1){
                lIS.set(lowerBoundIndex, nums[i]);
            }    
            else{
                lIS.add(nums[i]); 
            }        
        }

        return lIS.size();
    }


    public int getLowerBoundIndex(int target){
        int start = 0;
        int end = lIS.size() - 1;
        int result= -1;

        while(start <=  end){
            int mid = start +((end-start)/2);

            if(lIS.get(mid) >= target){
                result = mid;
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }

        return result;
    }
}