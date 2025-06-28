class Solution {
    List<List<String>> ans;

    public List<List<String>> partition(String s) {
        ans=new ArrayList<>();

        helper(new ArrayList<>(),s);
        return ans;
    }

    public void helper(List<String> currentPartitions, String s){
        if(s.length()==0){
            ans.add(new ArrayList<>(currentPartitions));
            return;
        }

        for(int partition=1;partition<=s.length();partition++){
            String prefix=s.substring(0,partition); 
            String remaining=s.substring(partition); 

            if(isPalindrome(prefix)){
                currentPartitions.add(prefix);
                helper(currentPartitions,remaining);
                currentPartitions.removeLast();
            }
        }
    }

    public boolean isPalindrome(String str){
        int i=0,j=str.length()-1;
        
        if(str.length()==1)
            return true;

        while(i<=j){
            if(str.charAt(i)!=str.charAt(j))
                return false;

            i++;
            j--;
        }

        return true;
    }
}