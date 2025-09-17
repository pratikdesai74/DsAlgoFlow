class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int l1=text1.length(); //rows
        int l2=text2.length(); //cols
        /*
        dp[i][j] --> Longest common subsequence (LCS) of text1 till length i, with text2 till length j
        dp[l1][l2] --> Longest common subsequence (LCS) of text1 till length l1, with text2 till length l2
        */
        
        /*
        Base case: 
        first row and first columns all values are to be kept 0, as for 0 length of either text1 with any length of text2
        or vise versa, there wont be any common char 
        */

        int[][] dp=new int[l1+1][l2+2];

        for(int i=1; i<=l1; i++){
            for(int j=1; j<=l2; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    /*
                    if current char matches from text1 with same index char from text2
                    increase length of LCS by 1 in previous diagonal cell (as both the chars are matching, so take preevious state [i-1][j-1], here we are only considering 1 older state, which is previous state of i and j)
                    */
                    dp[i][j]= 1+ dp[i-1][j-1]; // 1(own contribution)+ diagonally previous cell
                }
                else{
                    /*
                    if current char from text1 dont match with same index char from text2
                    we wont increment the LCS length,
                    but moving forword we need to decide (Maximum out of all 3 previous states) and update the value
                    */

                    int case1= dp[i-1][j]; //top of current cell (LCS value when i index was 1 less than current and j at same position)
                    int case2= dp[i][j-1]; //left of current cell (LCS value when j index was 1 less than current and i at same position)
                    int case3= dp[i-1][j-1]; // diagonally previous cell (LCS value when j index was 1 less than current and i at same position)

                    dp[i][j]=Math.max( Math.max(case1,case2),case3);
                }
            }
        }

        return dp[l1][l2];
    }
}

//Good test case
//bsbininm
//jmjkbkjkv