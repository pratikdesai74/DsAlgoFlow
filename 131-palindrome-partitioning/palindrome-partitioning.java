class Solution {
    List<List<String>> ans;

    public List<List<String>> partition(String s) {
        ans=new ArrayList<>();

        //char[] charArray=s.toCharArray();
        helper(new ArrayList<>(),s,0);
        return ans;
    }

    public void helper(List<String> strList, String s, int partIndex){
        if(partIndex==s.length()){
            ans.add(new ArrayList<>(strList));
            return;
        }

        for(int i=partIndex;i<s.length();i++){
            //char[] newArray = Arrays.copyOfRange(charArray, partIndex, i+1);
            String str=s.substring(partIndex,i+1); //newArray.toString();
            //System.out.println("str: "+str);

            if(isPalindrome(str)){
                strList.add(str);
                helper(strList,s,i+1);
                strList.removeLast();
            }
        }
    }

    public boolean isPalindrome(String str){
        int i=0,j=str.length()-1;

        while(i<=j){
            if(str.charAt(i)!=str.charAt(j))
                return false;

            i++;
            j--;
        }

        return true;
    }
}