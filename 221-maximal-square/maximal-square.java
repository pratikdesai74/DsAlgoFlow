class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int maxSide=0; // length or breadth

        int dp[][] = new int[m][n];
        
        // base case : first column
        for(int i=0; i<m; i++){
            dp[i][0] = Character.getNumericValue(matrix[i][0]);
            maxSide=Math.max(maxSide, dp[i][0]);
            System.out.println(dp[i][0]+" | ");
        }
        System.out.println("---------------------------------");
        // base case : first row
        for(int j=0; j<n; j++){
            dp[0][j] = Character.getNumericValue(matrix[0][j]);
            maxSide=Math.max(maxSide, dp[0][j]);
            System.out.print(dp[0][j]+" | ");
        }
        System.out.println("");
        System.out.println("---------------------------------");
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(Character.getNumericValue(matrix[i][j]) != 0){
                    int leftCellValue = dp[i][j-1];
                    int topCellValue = dp[i-1][j];
                    int diagonallyLeftCell = dp[i-1][j-1];
                    
                    dp[i][j] = 1+ Math.min(diagonallyLeftCell, Math.min(leftCellValue,topCellValue));
                    maxSide=Math.max(maxSide, dp[i][j]);
                }
                System.out.print(dp[i][j]+" | ");
            }
            System.out.println("");
            System.out.println("---------------------------------"+i+" th row done");
        }
        
        
        return maxSide * maxSide;
    }
}