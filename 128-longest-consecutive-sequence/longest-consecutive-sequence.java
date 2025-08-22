class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set=new HashSet<>();
        int maxLen=0;

        for(int num:nums){
            set.add(num);
        }

        for(int num:set){
            
            if(!set.contains(num-1)){
                int length=1;
                while(set.contains(num+length)){
                    length++; 
                }

                maxLen=Math.max(maxLen,length);
            }
        }

        return maxLen;
    }
}