class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n=s.length();
        Set<String> set=new HashSet<>();

        for(String word: wordDict){
            set.add(word);
        }

        /*
        dp[i] --> shows if there is any word starting index i, is present in given set of words of wordDict

        base case : dp[n]=1 :: this shows that the main word starting from index 0 breaks at n-1 index
        */

        int[] dp=new int[n+1];
        dp[n]=1;

        /*
        1. trverse from last index n-1 to 0 (for index i) and index j would trverse from i to n-1
        2. for every i th index, we will check if any substring from index i to j, if present in given set of words
            and if there is valid word starting next(which we get byu checking if j+1 index have 1 value)

        ex. 01234567
            leetcode
        1. for i= 7 
            check every substring from j = 7 to 7 i.e only e which isnt present in set so we will keep dp[7] =0
        2. for i= 6 
            check every substring from j = 6 to 7 i.e de,e both substrings/words arent present in set so we will keep dp[6] =0 
        3. for i= 5 
            check every substring from j = 5 to 7 i.e ode,de,e both substrings/words arent present in set so we will keep dp[5] =0 
        4. for i= 4 
            check every substring from j = 5 to 7 i.e code,ode,de,e :: code word is present in set and next index dp[j+1] == dp[n] ==1 so we will make  dp[4] =1
        ...similerly we will check all the index    
        */

        for(int i=n-1; i>=0;i--){
            for(int j=i; j<n; j++){
                String word = s.substring(i,j+1);

                if(set.contains(word) && dp[j+1]==1){
                    dp[i]=1;
                }
            }
        }

        return dp[0]==1;
    }
}