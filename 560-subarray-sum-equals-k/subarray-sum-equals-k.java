class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> runningSumFrequency= new HashMap<>();
        int sum=0;
        int countOfSubarray=0;

        runningSumFrequency.put(0,1);

        for(int num:nums){
            sum+=num;
            int runningSumMatchingKey = sum-k; 
            
            if(runningSumFrequency.containsKey(runningSumMatchingKey)){
               countOfSubarray+= runningSumFrequency.get(runningSumMatchingKey);
            }

            runningSumFrequency.put(sum,runningSumFrequency.getOrDefault(sum,0)+1);

        }

        return countOfSubarray;
    }
}