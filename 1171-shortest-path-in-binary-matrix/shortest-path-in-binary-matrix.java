// class Pair{
//     int row;
//     int col;
//     int steps;

//     public Pair(int row,int col,int steps){
//         this.row=row;
//         this.col=col;
//         this.steps=steps;
//     }
// }
// class Solution {
//     public int shortestPathBinaryMatrix(int[][] grid) {
//         int m=grid.length;
//         int n=grid[0].length;

//         int[][] visited =new int[m][n];
//         Queue<Pair> q= new LinkedList<>();

//         if(grid[0][0]==1 || grid[m-1][n-1]==1)
//             return -1;

//         q.add(new Pair(0,0,1));

//         //regular bfs

//         while(q.size()>0){
//             Pair p=q.poll();
//             int i=p.row;
//             int j=p.col;
//             int steps=p.steps;

//             //System.out.println("i:"+i+" j:"+j+" :: steps: "+steps);
//             visited[i][j]=1;

//             if(i==m-1 && j==n-1)
//                 return steps;

//             int[] x={-1,0,1,0,-1,1,1,-1};
//             int[] y={0,-1,0,1,-1,1,-1,1};

//             for(int k=0;k<8;k++){
//                 int newX=i+x[k];
//                 int newY=j+y[k];

//                 if(newX>=0 && newX<m && newY>=0 && newY<n
//                  && visited[newX][newY]==0 && grid[newX][newY]==0){
//                     q.add(new Pair(newX, newY,steps+1));
//                  }
//             }
//         }

//         return -1;
//     }
// }

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        // Step 1: Handle impossible starting and ending cases
        // If start OR end cell is blocked, no path exists
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;

        // Special case: If it's a single cell and it's open, we are already at the destination
        if (n == 1) return 1;

        // Step 2: All 8 possible directions we can move in
        // Each pair represents (rowChange, colChange)
        int[][] dirs = {
            {-1, -1}, {-1, 0}, {-1, 1}, // Top-left, Top, Top-right
            {0, -1},          {0, 1},   // Left,       Right
            {1, -1},  {1, 0}, {1, 1}    // Bottom-left, Bottom, Bottom-right
        };

        // Step 3: BFS setup
        // Queue stores {row, col, stepsSoFar}
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][n]; // To avoid revisiting cells

        // Start BFS from (0,0) with 1 step
        q.offer(new int[]{0, 0, 1});
        visited[0][0] = true;

        // Step 4: BFS loop
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0], c = curr[1], dist = curr[2];

            // If we reached the destination, return the steps taken
            if (r == n - 1 && c == n - 1) return dist;

            // Try all 8 directions
            for (int[] d : dirs) {
                int nr = r + d[0]; // New row
                int nc = c + d[1]; // New col

                // Check boundaries, open cell, and not visited before
                if (nr >= 0 && nr < n && nc >= 0 && nc < n &&
                    grid[nr][nc] == 0 && !visited[nr][nc]) {

                    visited[nr][nc] = true;       // Mark as visited
                    q.offer(new int[]{nr, nc, dist + 1}); // Add to queue with updated distance
                }
            }
        }

        // Step 5: If BFS finishes without reaching destination → no path exists
        return -1;
    }
}