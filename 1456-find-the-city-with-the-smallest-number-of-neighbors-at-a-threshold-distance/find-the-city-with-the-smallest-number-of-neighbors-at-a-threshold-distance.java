class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        /* smallest distance from every nodes to all other nodes
            so use floyed warshell algo
            watch strivers video
        */

        int[][] dist= new int[n][n];

        /* mark every node =Integer.MAX_VALUE, except diagonal nodes
        - so that leter we can get minimum distance at that node 
        - when i==j then keep as 0, that means distance of city i from same city i
        - 
        */
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j)
                    dist[i][j]=Integer.MAX_VALUE;
            }
        }

        /* 
        - add edges in the distance matrix
        */
        for(int[] edge:edges){
            int from=edge[0];
            int to=edge[1];
            int distance=edge[2];

            dist[from][to]=distance;
            dist[to][from]=distance;
        }

        /* 
        - floyed warshell algo, minimum of current distance and from kth node as stop
        */
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(dist[i][k]==Integer.MAX_VALUE || dist[k][j]==Integer.MAX_VALUE)
                        continue;
                    
                    dist[i][j]=Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                }
            }
        }

        /* 
        - calculate city with mimum number of neighbouring cities within threshhold distnace
        */
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