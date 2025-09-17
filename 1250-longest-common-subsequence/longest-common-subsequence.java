class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int l1=text1.length(); //rows
        int l2=text2.length(); //cols

        int[][] dp=new int[l1+1][l2+2];

        for(int i=1; i<=l1; i++){
            for(int j=1; j<=l2; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j]= 1+ dp[i-1][j-1];
                }
                else{
                    int condition1= dp[i-1][j];
                    int condition2= dp[i][j-1];
                    int condition3= dp[i-1][j-1];

                    dp[i][j]=Math.max( Math.max(condition1,condition2),condition3);
                }
            }
        }

        return dp[l1][l2];
    }
}