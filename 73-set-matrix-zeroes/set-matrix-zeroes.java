class Solution {
    public void setZeroes(int[][] matrix) {
        int numOfRows=matrix.length;
        int numOfCols=matrix[0].length;

        int row0=matrix[0][0];

        for(int row=0; row<numOfRows; row++){
            for(int col=0; col<numOfCols; col++){
                
                if(matrix[row][col]==0){
                    matrix[0][col]=0;
                    if(row!=0){
                        matrix[row][0]=0;
                    }
                    else{
                        row0=0;
                    }       
                }
            }
        }

        for(int row=1; row<numOfRows; row++){
            for(int col=1; col<numOfCols; col++){
                
                if(matrix[0][col]==0 || matrix[row][0]==0){
                    matrix[row][col]=0;      
                }
            }
        }

        if(matrix[0][0]==0){
            for(int i=0;i<numOfRows;i++){
                matrix[i][0]=0;
            }
        }

        if(row0==0){
            for(int i=0;i<numOfCols;i++){
                matrix[0][i]=0;
            } 
        }
    }
}