class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        /* smallest distance from every nodes to all other nodes
            so use floyed warshell algo
            watch strivers video
        */

        int[][] dist= new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j)
                    dist[i][j]=Integer.MAX_VALUE;
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j)
                    dist[i][j]=Integer.MAX_VALUE;
            }
        }

        for(int[] edge:edges){
            int from=edge[0];
            int to=edge[1];
            int distance=edge[2];

            dist[from][to]=distance;
            dist[to][from]=distance;
        }

        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(dist[i][k]==Integer.MAX_VALUE || dist[k][j]==Integer.MAX_VALUE)
                        continue;
                    
                    dist[i][j]=Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                }
            }
        }

        int minNoOfCities=n;
        int cityNo=-1;

        for(int i=0;i<n;i++){
            int noOfNeighboursWithinThreshold=0;
            for(int j=0;j<n;j++){
                if(dist[i][j]<=distanceThreshold){
                    noOfNeighboursWithinThreshold++;
                }
            }

            if(noOfNeighboursWithinThreshold <= minNoOfCities){
                minNoOfCities = noOfNeighboursWithinThreshold;
                cityNo=i;
            }
        }     

        return cityNo;
    }
}