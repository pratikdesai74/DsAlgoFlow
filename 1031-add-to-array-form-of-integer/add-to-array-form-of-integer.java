class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        
        int i=num.length-1;
        int carray=0;
        int mod=0;
        List<Integer> ans=new ArrayList<>();
        int val=k;

        while(i>=0){
            mod=val%10;
            val=val/10;
            int sum= mod+num[i];
            ans.add(sum%10);
            carray=sum/10;
            val+=carray;
            i--;
        }
        
        while(val>0){
            ans.add(val%10);
            val/=10;
        }

        Collections.reverse(ans);
        return ans;
    }
}