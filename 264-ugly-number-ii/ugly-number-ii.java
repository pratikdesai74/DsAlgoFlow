class Solution {
    public int nthUglyNumber(int n) {
        List<Integer> nums=new ArrayList<>();
        nums.add(1);
        int p2=0,p3=0,p5=0;

        while(nums.size()<n){
            int twoMultiple= nums.get(p2)*2;
            int threeMultiple= nums.get(p3)*3;
            int fiveMultiple= nums.get(p5)*5;

            int minMultiple=Math.min(twoMultiple,Math.min(threeMultiple,fiveMultiple));
            nums.add(minMultiple);

            if(minMultiple==twoMultiple) p2++;
            if(minMultiple==threeMultiple) p3++;
            if(minMultiple==fiveMultiple) p5++;
        }

        return nums.get(n-1);
    }
}