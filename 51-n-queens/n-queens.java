class Solution {
    List<List<String>> ans;
    public List<List<String>> solveNQueens(int n) {
        ans=new ArrayList<>();
        char[][]board= new char[n][n];

        for(int i=0;i<board.length;i++){
            Arrays.fill(board[i],'.');
        }
        nQueens(board,0);
        return ans;
    }

    public void nQueens(char[][] arr,int row){
        if(row==arr.length){
            List<String> currentStringList=new ArrayList<>();

            for(int r=0;r<arr.length;r++){
                currentStringList.add(new String(arr[r]));
            }
            ans.add(currentStringList);
            return;
        }

        for(int col=0;col<arr.length;col++){
            if(isSafe(arr,row,col)){
                arr[row][col]='Q';
                nQueens(arr,row+1);
                arr[row][col]='.';
            }
        }
    }

    public static boolean isSafe(char[][] arr,int row, int col){
        //vertical check
        for(int r=row;r>=0;r--)
            if(arr[r][col]=='Q') return false;

        //positive diagonal
        for(int r=row,c=col;r>=0 && c>=0;r--,c--)
            if(arr[r][c]=='Q') return false;

        //negative diagonal
        for(int r=row,c=col;r>=0 && c<arr.length;r--,c++)
            if(arr[r][c]=='Q') return false;    

        return true;
    }
}