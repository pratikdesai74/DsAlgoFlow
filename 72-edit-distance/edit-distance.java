class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n =word2.length();

        /*
        dp[i][j] --> gives number of minimum edit operations required to make ith length of word1 to jth length of word2
    i.e dp[m][n] --> gives number of minimum edit operations required to make word1 till length m to word2 till length n
        */
        int[][]dp= new int [m+1][n+1];

        /* Base case:
        first column: where we put min operations to convert every length (from 0 to n) of word1 To 0 length ("" : blank string) of word2
        */
        for(int i=0; i<=m;i++){
            dp[i][0]=i;
        }

        /* Base case:
        first row: where we put min operations to convert 0 length ("" : blank string) of word1 To every length (from 0 to n) of word1
        */
        for(int j=0; j<=n;j++){
            dp[0][j]=j;
        }


        for(int i=1;i<=m;i++){
            for(int j=1; j<=n;j++){
               //if ith character of word1 matches with jth character of word2 :: that means we dont have to do any operation for this character, so will use the same value (min number of operations) of previous state that is dp[i-1][j-1]
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }
                else{
                    /*
                    If both the characters dont match we have 3 options/cases to make thoese charts match::

                    1. Delete case (dp[i-1][j])
                    Think: we're matching "ab" → "ax".

                    Last letters: 'b' (word1) vs 'x' (word2).
                    Mismatch.
                    Option 1 = Delete 'b' from word1.

                    After deleting, "ab" → "a".

                    Now the subproblem is: "a" → "ax".

                    That subproblem is dp[i-1][j] (one fewer char from word1, same chars from word2).
                    \U0001f449 Delete means: skip a character from word1.
                    -------------------------------------

                    2. Insert case (dp[i][j-1])
                    Again: "ab" → "ax".

                    Last letters: 'b' vs 'x'.
                    Option 2 = Insert 'x' into word1 after "ab".

                    "ab" + 'x' = "abx".

                    Now the 'x' matches with word2's last 'x'.
                    So the subproblem reduces to: "ab" → "a".

                    That subproblem is dp[i][j-1] (same length of word1, one fewer char from word2).
                    \U0001f449 Insert means: add a character from word2 into word1 to match.
                    -------------------------------------

                    3. Replace case (dp[i-1][j-1])

                    Option 3 = replace 'b' → 'x'.
                    Then "ab" → "ax".
                    Subproblem: "a" → "a".

                    That's dp[i-1][j-1].
                    */

                    
                    
                    int deleteCase = 1+ dp[i-1][j];

                    int insertCase = 1+ dp[i][j-1];

                    int replaceCase = 1+ dp[i-1][j-1];

                    dp[i][j] = Math.min(deleteCase, Math.min(insertCase, replaceCase));
                }

            }
        }

        return dp[m][n];
    }
}