class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set=new HashSet<>();
        int maxLen=0;

        for(int num:nums){
            set.add(num);
        }

        for(int val:set){
            
            if(!set.contains(val-1)){
                int length=1;
                while(set.contains(val+length)){
                    length++; 
                }

                maxLen=Math.max(maxLen,length);
            }
        }

        return maxLen;
    }
}