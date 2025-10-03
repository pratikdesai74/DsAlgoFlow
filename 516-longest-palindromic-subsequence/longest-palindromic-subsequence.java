class Solution {
    public int longestPalindromeSubseq(String s) {
        StringBuilder sb=new StringBuilder(s);
        String sReversed = sb.reverse().toString();

        int length=s.length();

        //dp[i][j] --> longest common subsequence between string s till length i with string sReversed till length j
        //dp[m][n] --> longest common subsequence between string s till length m with string sReversed till length n

        int m =length;
        int n =length;

        int[][] dp=new int [m+1][n+1];

        for(int i=1;i<=m ;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1) == sReversed.charAt(j-1)){
                    dp[i][j]= 1+ dp[i-1][j-1];
                }
                else{
                    int case1 = dp[i-1][j];
                    int case2 = dp[i][j-1];
                    int case3 = dp[i-1][j-1];

                   dp[i][j]= Math.max(case1,Math.max(case2, case3)); 
                }
            }
        }


        return dp[m][n];
    }
}