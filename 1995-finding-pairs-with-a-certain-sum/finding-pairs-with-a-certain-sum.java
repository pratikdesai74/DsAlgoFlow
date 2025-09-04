class FindSumPairs {
    int[] numArr1;
    int[] numArr2;
    Map<Integer,Integer> map= new HashMap<>();

    public FindSumPairs(int[] nums1, int[] nums2) {
        numArr1=nums1;
        numArr2=nums2;

        for(int num: nums2){
            map.put(num,map.getOrDefault(num,0)+1);
        }
    }
    
    public void add(int index, int val) {
        map.put(numArr2[index],map.get(numArr2[index])-1);
        numArr2[index]+=val;
        map.put(numArr2[index],map.getOrDefault(numArr2[index],0)+1);
    }
    
    public int count(int tot) {
        int pairCount=0;
        for(int num: numArr1){
            if(map.containsKey(tot-num)){
                pairCount+=map.get(tot-num);
            }
        }

        return pairCount;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */