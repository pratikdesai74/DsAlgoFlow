/* Solved by myself:
    Approach:
    1. we need to traverse from a source node to every other node, so we can use dijekstra algo
    2. also we might reach to any specific node through 2 routes, but we need to maintain min time require to   
    reach that node, we will maintain timeArr which holds the minimum time require to reach that node.
    3. we do reguler things:
        i. create adjecency list 
        ii. create a queue(why priority queue is not required as we are going to push step by step nodes,
        like nodes on time 1 are pushed first, and as we go further we push 2nd layer of time 2 )
        iii. we set time for source node as 0 and add one entry into the queue as source node and time as 0.
        iv. for every entry in queue will check the neighbour nodes with their time and allow only when the 
        effective time from source is less than current time in timeArr 
    4. after this we will check if any node is not visited(if its value equqal to Integer.MAX_VALUE), 
    then send -1
    5. will find out max time out of all the nodes and return it
*/
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