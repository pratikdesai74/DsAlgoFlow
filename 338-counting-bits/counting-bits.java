class Solution {
    public int[] countBits(int n) {
        int []ans=new int[n+1];
        ans[0]=0;

        for(int i=1;i<=n;i++){
            ans[i]=count1s(i);
        }

        return ans;
    }

    public int count1s(int num){
        int count=0;
        for(int i=0;i<32;i++){
            if((num &1) >0)
                count++;
            num=num>>1;    
        }
        return count;
    }
}