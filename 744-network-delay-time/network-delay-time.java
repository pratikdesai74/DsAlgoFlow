class Pair{
    int node;
    int time;

    public Pair(int node,int time){
        this.node=node;
        this.time=time;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adList=new ArrayList<>();
        for(int i=0;i<=n;i++)
            adList.add(new ArrayList<>());

        for(int[]connection: times){
            adList.get(connection[0]).add(new Pair(connection[1],connection[2]));
        }

        int[] timeArr= new int[n+1];
        Arrays.fill(timeArr,Integer.MAX_VALUE);

        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(k,0));
        timeArr[k]=0;

        while(q.size()>0){
            Pair parentPair= q.poll();
            int node= parentPair.node;
            int time= parentPair.time;

            for(Pair neighbourPair: adList.get(node)){
                int neighbourNode= neighbourPair.node;
                int neighbourTime= neighbourPair.time;

                if(time+neighbourTime < timeArr[neighbourNode]){
                    timeArr[neighbourNode]=time+neighbourTime;
                    q.add(new Pair(neighbourNode,timeArr[neighbourNode]));
                }
            }
        }

        int minimumTimeToReachEveryNode=0;
        for(int i=1;i<=n;i++){
            if(timeArr[i]==Integer.MAX_VALUE)
                return -1;

            minimumTimeToReachEveryNode = Math.max(minimumTimeToReachEveryNode,timeArr[i]);
        }

        return minimumTimeToReachEveryNode;
    }
}