class Solution {
    public int maxSubArray(int[] nums) {
        /*
            Very important question: Use Kaden's algorithm
            1. Traverse through the array, add to currentSum
            2. maintain Max Sum value every time we update the currentSum
            3. Whenever currentSum becomes less than 0, restart the currentSum to 0
        */
        int currentSum = 0;
        int maxSum =Integer.MIN_VALUE;

        for(int num: nums){
            currentSum += num;
            maxSum = Math.max(maxSum, currentSum);

            if(currentSum < 0){
                currentSum = 0;
            }
        }

        return maxSum;
    }
}