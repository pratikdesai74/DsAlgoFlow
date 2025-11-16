/*
    Watch strivers video of this question.
    1. we will wont consider 0's which are connected to the edges(in first and last columns and rows)
    2. all other can be marked 'X'
*/
class Solution {
    public void dfs(int i,int j,int[][] visited, char[][] board, int[] x,int[] y, int rows, int cols){
        visited[i][j]=1;

        for(int k=0;k<4;k++){
            int newX= i+x[k];
            int newY= j+y[k];

            if(newX>=0 && newX<rows && newY>=0 && newY<cols && 
            visited[newX][newY]==0 && board[newX][newY]=='O'){
                dfs(newX,newY,visited,board,x,y,rows,cols);
            }

        }

    }
    public void solve(char[][] board) {
        int rows= board.length;
        int cols= board[0].length;

        int[][] visited = new int[rows][cols];

        int[] x={-1,0,1,0};
        int[] y={0,-1,0,1};

        // 1st and last row
        for(int j=0;j<cols;j++){
            if(visited[0][j]==0 && board[0][j]=='O')
                dfs(0,j,visited,board,x,y,rows,cols);


            if(visited[rows-1][j]==0 && board[rows-1][j]=='O')
                dfs(rows-1,j,visited,board,x,y,rows,cols);    
        }

        //1st and last columns
        for(int i=0;i<rows;i++){
            if(visited[i][0]==0 && board[i][0]=='O')
                dfs(i,0,visited,board,x,y,rows,cols);


            if(visited[i][cols-1]==0 && board[i][cols-1]=='O')
                dfs(i,cols-1,visited,board,x,y,rows,cols);    
        }

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(board[i][j]=='O' && visited[i][j]==0)
                    board[i][j]='X';
            }
        }
    }
}