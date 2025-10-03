class Solution {
    public int maximalSquare(char[][] matrix) {
        /*
        This question asks to get maximum length of square matrix, and this question asks about maximum area
        */
        int m = matrix.length;
        int n = matrix[0].length;
        int MaxLengthOfMatrix=0; // length or breadth of square matrix

        /*
        dp[i][j] : maximum length of square till cell [i][j] (but its left top cell can be any cell, not specifically need to be cell[0][0]
        so we need to keep track of maximum length/side of square matrix we encounter while traversing from cell [0][0] till [m-1][n-1]
        */
        int dp[][] = new int[m][n];
        
        /*
        base case : first column
        as they cant have more than 1 cell at a time as a square matrix, we can set same values in dp, what we have in input matrix
        and also will keep track of maxSide/maxLength of square matrix
        */
        for(int i=0; i<m; i++){
            dp[i][0] = Character.getNumericValue(matrix[i][0]);
            MaxLengthOfMatrix=Math.max(MaxLengthOfMatrix, dp[i][0]);
        }

        // base case : first row :: same as column
        for(int j=0; j<n; j++){
            dp[0][j] = Character.getNumericValue(matrix[0][j]);
            MaxLengthOfMatrix=Math.max(MaxLengthOfMatrix, dp[0][j]);
        }

        /*
        The main condition we check: if the current matrix cell is greater than 0 i.e 1, if its 0 then it cant be counted in.

        and if current matrix cell is 1 ,
            then : dp[i][j] = 1+ min (leftCell, topCell, diagonallyPreviousCell)

        also we will be maintaing the maxSide/MaxLength 
        so we get maxArea =  MaxLength * MaxLength    
        */

        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(Character.getNumericValue(matrix[i][j]) != 0){
                    int leftCellValue = dp[i][j-1];
                    int topCellValue = dp[i-1][j];
                    int diagonallyLeftCell = dp[i-1][j-1];
                    
                    dp[i][j] = 1+ Math.min(diagonallyLeftCell, Math.min(leftCellValue,topCellValue));
                    MaxLengthOfMatrix=Math.max(MaxLengthOfMatrix, dp[i][j]);
                }
            }
        }
        
        
        return MaxLengthOfMatrix * MaxLengthOfMatrix;
    }
}