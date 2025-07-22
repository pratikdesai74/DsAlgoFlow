class Solution {
    public int nthUglyNumber(int n) {
        int[] uglyNumbers=new int[n];
        uglyNumbers[0]=1;
        int p2=0,p3=0,p5=0;

        for(int i=1;i<n;i++){
            int twoMultiple= uglyNumbers[p2]*2;
            int threeMultiple= uglyNumbers[p3]*3;
            int fiveMultiple= uglyNumbers[p5]*5;

            int minMultiple=Math.min(twoMultiple,Math.min(threeMultiple,fiveMultiple));
            uglyNumbers[i]=minMultiple;
            
            if(minMultiple==twoMultiple) p2++;
            if(minMultiple==threeMultiple) p3++;
            if(minMultiple==fiveMultiple) p5++;
        }

        return uglyNumbers[n-1];
    }
}