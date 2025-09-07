class Solution {
public:
    int lastStoneWeight(vector<int>& stones) {
        while(stones.size()>1){
            sort(stones.begin(), stones.end(),greater<int>());
            if(stones[0]>stones[1]){
            stones[0]=stones[0]-stones[1];
            stones.erase(stones.begin()+1);
            }
            else{
                stones.erase(stones.begin());
                stones.erase(stones.begin());
            }
        }
        if(stones.size()==1){
            return stones[0];
        }
        return 0;
    }
};