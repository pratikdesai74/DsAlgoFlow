class DisjointSet{
    int noOfNode;
    int[] size;
    int[] parent;

    public DisjointSet(int noOfNode){
        this.noOfNode = noOfNode;
        size=new int[noOfNode+1];

        Arrays.fill(size,1);
        parent=new int[noOfNode+1];
        
        for(int i=0;i<=noOfNode;i++)
            parent[i]=i;
    }

    public int ultiMateParent(int node){
        if(parent[node]==node)
            return node;

        return ultiMateParent(parent[node]);    
    }

    public boolean uninionBySize(int node1, int node2){
        int ultiMateParentNode1 = ultiMateParent(node1);
        int ultiMateParentNode2 = ultiMateParent(node2);

        if(ultiMateParentNode1 == ultiMateParentNode2){
            return true;
        }
        else{
            if(size[ultiMateParentNode1] < size[ultiMateParentNode2]){
                parent[ultiMateParentNode1] = ultiMateParentNode2;
                size[ultiMateParentNode2]+=size[ultiMateParentNode1];
            }
            else{
                parent[ultiMateParentNode2] = ultiMateParentNode1;
                size[ultiMateParentNode1]+=size[ultiMateParentNode2];
            }
        }

        return false;
    }
}
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n= edges.length;
        int[] ans= new int[2];

        DisjointSet ds= new DisjointSet(n);

        for(int[] edge : edges){
            int fromNode= edge[0];
            int toNode= edge[1];

            if(ds.uninionBySize(fromNode, toNode)){
                ans[0]=fromNode;
                ans[1]=toNode;
            }
        }

        return ans;
    }
}