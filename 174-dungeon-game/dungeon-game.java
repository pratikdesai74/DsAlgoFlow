class Solution {
    // public int calculateMinimumHP(int[][] dungeon) {
    //     /*
    //     every cells number 
    //         -ve number = number of health require to defeat the demon at that cell (this number of knight's health would be reduced)
    //         +ve number =  herbs energy which will increate knights energy (this number energy would be added up in knight's health/energy )
    //     */
    //     int m= dungeon.length; //rows
    //     int n= dungeon[0].length; // colomns

    //     /*
    //     dp[i][j] --> minimum number of health of knight require to reach princess at cell [m][n] from cell [i][j]
    //     dp[0][0] --> minimum number of health of knight require to reach princess at cell [m][n] from cell [0][0]
    //     */

    //     int[][] dp=new int[m][n];

    //     /*
    //         base condition: if there is only one cell
    //         1. -ve energy cell(consist of demon to defeat) : we need such number of energy, when it will addup with cells energy, still the final sum would be +ve (1 or greater than 1)
    //         example: 
    //             -5 + {how much energy should the knight already have when he enters this cell} = 1
    //             {how much energy should the knight already have when he enters this cell} = 1-(-5);
    //                                                                                       =  6;

    //         2. +ve energy cell(consist of herbs) : we dont need more than 1 to survive in this cell, so even if the cell energy is more than 1 still we will consider 1
    //     */
    //     if(dungeon[m-1][n-1] < 0){
    //         dp[m-1][n-1]= 1 - dungeon[m-1][n-1];
    //     }
    //     else{
    //         dp[m-1][n-1] = 1;
    //     }

    //     /*base case : last row :: we can only move right and not down

    //     minimumHealthRequireToEnterThisCell = dp matrix's previous cell (right of current cell) - current cell value from dungeon matrix

    //     1. minimumHealthRequireToEnterThisCell comes 0 or -ve : that means with that much minimum -ve knight health(while entering this current dungeon cell) he can survive, as he will get positive additional health in current cell, so he's having more than required health to carry forword, but as we only need 1 to survive, we will consider 1 in that dp cell.

    //     2. minimumHealthRequireToEnterThisCell +ve : that means minimum that much number of health the knight should carry before entering the current cell

    //     */
    //     for(int j=n-2; j>=0; j--){
    //         int minimumHealthRequireToEnterThisCell = dp[m-1][j+1] - dungeon[m-1][j];
    //         dp[m-1][j] = minimumHealthRequireToEnterThisCell >0 ? minimumHealthRequireToEnterThisCell: 1;
    //     }

    //     /* base case : last colomn :: we can only move down and not right
    //      same as we did for base case : last row
    //     */
    //     for(int i=m-2; i>=0; i--){
    //         int minimumHealthRequireToEnterThisCell = dp[i+1][n-1] - dungeon[i][n-1];
    //         dp[i][n-1]= minimumHealthRequireToEnterThisCell >0 ? minimumHealthRequireToEnterThisCell: 1;
    //     }

    //     /* After getting base cases inplace: last row and colomn :: we can start iterating from row = m-2 and coloum = n-2
    //         1. As every dp cell represents the min health require to enter that cell
    //         2. We have to choose minimum of 2 options available : right cell and down cell
    //         3. Then need to minus current dungeon cell value from that minimum value.
    //         4. which will give us the minimum health require for the current cell, but like we did for the base cases, if the value is -ve then we will consider bare minimum health required to survive = 1
    //         and if it is +ve we will consider as it is
            
    //     */
    //     for(int i=m-2; i>=0; i--){
    //         for(int j=n-2; j>=0; j--){
    //             int rightCell= dp[i][j+1];
    //             int downCell= dp[i+1][j];

    //             int minimumHealthRequireToEnterThisCellExcludingCurrentCellNumber = Math.min(rightCell, downCell);
                
    //             int minimumHealthRequireToEnterThisCell = minimumHealthRequireToEnterThisCellExcludingCurrentCellNumber - dungeon[i][j];

    //             dp[i][j] = minimumHealthRequireToEnterThisCell >0 ? minimumHealthRequireToEnterThisCell: 1;
    //         }
    //     }

    //     return dp[0][0];
    // }

    public int calculateMinimumHP(int[][] dungeon) {
        /*
        every cells number 
            -ve number = number of health require to defeat the demon at that cell (this number of knight's health would be reduced)
            +ve number =  herbs energy which will increate knights energy (this number energy would be added up in knight's health/energy )
        */
        int m= dungeon.length; //rows
        int n= dungeon[0].length; // colomns

        /*
        dp[i][j] --> minimum number of health of knight require to reach princess at cell [m][n] from cell [i][j]
        dp[0][0] --> minimum number of health of knight require to reach princess at cell [m][n] from cell [0][0]
        */

        int[][] dp=new int[m+1][n+1];

        /*
            base condition: 
            1. We will fill last row and column as infinity
            2. The princes is at cell [m-1][n-1], so to we will put 1(bare minimum) health required by knight to consider him alive, on both right and down cell of that last cell(where the princes is located)
        */
        for(int i=0;i<=m;i++){
            dp[i][n]=Integer.MAX_VALUE;
        }

        for(int j=0;j<=n;j++){
            dp[m][j]=Integer.MAX_VALUE;
        }

        
        dp[m][n-1]=1;
        dp[m-1][n]=1;

        /* After getting base cases inplace:: we can start iterating from row = m-1 and coloum = n-1
            1. As every dp cell represents the min health require to enter that cell
            2. We have to choose minimum of 2 options available : right cell and down cell
            3. Then need to minus current dungeon cell value from that minimum value.
            4. which will give us the minimum health require for the current cell, if the value is -ve or 0 then we will consider bare minimum health required to survive = 1 (we cannot consider -ve health as that means knight died)
            and if it is +ve we will consider as it is
            
        */
        for(int i=m-1; i>=0; i--){
            for(int j=n-1; j>=0; j--){
                int rightCell= dp[i][j+1];
                int downCell= dp[i+1][j];

                int minimumHealthRequireToEnterThisCellExcludingCurrentCellNumber = Math.min(rightCell, downCell);
                
                int minimumHealthRequireToEnterThisCell = minimumHealthRequireToEnterThisCellExcludingCurrentCellNumber - dungeon[i][j];

                dp[i][j] = minimumHealthRequireToEnterThisCell >0 ? minimumHealthRequireToEnterThisCell: 1;
            }
        }

        return dp[0][0];
    }
}