class Solution {
    public int triangleNumber(int[] nums) {
        int count=0;
        Arrays.sort(nums);
        for(int c=nums.length-1;c >= 2; c--){
            int a=0,b=c-1;
            while(a<b){
                //to consider triplet as valid triangle a+b>c, b+c>a, c+a>b
                // all three conditions should be satisfied
                // so we sorted the array , so that c >a, c>b
                // so only a+b>c can give us valid triangle triplet
                //as c is bigger tha a and b, adding any number to it doesnt affect 
                // these conditions b+c>a and c+a>b
                if((nums[a]+nums[b]) > nums[c]){
                    //if a+b >c then any number greater than a till the current b would 
                    // also be a+b > c , so add number of combinations (b-a) between a and b with 
                    // current c, as we can consider them as valid trangle triplets
                    count+=b-a;
                    b--;
                }
                else{
                    a++;
                }
            }
        }

        return count;
    }
}