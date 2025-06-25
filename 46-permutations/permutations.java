class Solution {
    List<List<Integer>> finalAns;
    public List<List<Integer>> permute(int[] nums) {
        finalAns =new ArrayList<>();
        helper(nums,new ArrayList<>(),new HashSet<>());
        return finalAns;
    }

    public void helper(int[]nums ,List<Integer> used,Set<Integer> set) {
        if(nums.length==used.size()){
            List<Integer> copyUsedList=new ArrayList<>(used); // as we will remove the same used array for next permutation, so in that case it will remove the already recorded permutation
            finalAns.add(copyUsedList);
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(!set.contains(nums[i])){ //if we have implemented used.contais(nums[i]), this contains alone will take O(n) to check linerly in list
                set.add(nums[i]);       // instead we can use hashSet to just to check if the element is already there in the used list 
                used.add(nums[i]);
                helper(nums,used,set);
                used.removeLast();
                set.remove(nums[i]);
            }
        }
    }
}