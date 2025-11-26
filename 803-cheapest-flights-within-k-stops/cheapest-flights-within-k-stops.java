class Pair{
    int node;
    int cost;

    public Pair(int node,int cost){
        this.node=node;
        this.cost=cost;
    }
}

class Tuple{
    int fromNode;
    int stops;
    int cost;

    public Tuple(int fromNode, int stops, int cost){
        this.fromNode=fromNode;
        this.stops=stops;
        this.cost=cost;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        List<List<Pair>> nodes= new ArrayList<>();
        Queue<Tuple> q= new LinkedList<>();
        int[] priceArr= new int[n];
        
        Arrays.fill(priceArr, Integer.MAX_VALUE);
        for(int i=0;i<n;i++)
            nodes.add(new ArrayList<>());

        
        for(int[] details:flights){
            int from=details[0];
            int to=details[1];
            int cost=details[2];

            nodes.get(from).add(new Pair(to,cost));
        }

        q.add(new Tuple(src,0,0));
        priceArr[src]=0;

        while(q.size()>0){
            Tuple tp= q.poll();
            int node=tp.fromNode;
            int stops=tp.stops;
            int cost=tp.cost; 

            //System.out.println("node: "+node+" :: stops: "+stops+" ::cost:"+cost);
            if(stops>k) break;

            for(Pair neighbourPair:nodes.get(node)){
                int neighbourNode= neighbourPair.node;
                int neighbourCost=neighbourPair.cost;

                if(cost+neighbourCost < priceArr[neighbourNode] && stops <=k){
                    priceArr[neighbourNode]=cost+neighbourCost;
                    q.add(new Tuple(neighbourNode,stops+1,cost+neighbourCost));
                }
            }
        }

        if(priceArr[dst] == Integer.MAX_VALUE)
            return -1;

        return priceArr[dst];
    }
}