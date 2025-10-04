class Solution {
    
    public int maxEnvelopes(int[][] envelopes) {
        int rows = envelopes.length;
        int cols = envelopes[0].length;

        Arrays.sort(envelopes, 
            (row1,row2)->{
                    if(row1[0] == row2[0]){
                        return row2[1] - row1[1];
                    }
                    else{
                        return row1[0] - row2[0];
                    }
            } 
        );
        
        int[] heightArray= new int[rows];

        for(int i =0; i<rows; i++){
            heightArray[i] = envelopes[i][1];
        }

        return longestIncreasingSubsequence(heightArray);
    }

    List<Integer> lIS = new ArrayList<>();

    public int longestIncreasingSubsequence(int[] heightArray){
        lIS.add(heightArray[0]);
        int len=heightArray.length;

        for(int i=1; i<len; i++){
            int lowerBoundIndex = getLowerBoundIndex(heightArray[i]);

            if(lowerBoundIndex != -1){ 
                /* 
                when there is a number present in list lIS : which is greater than or equal to current number
                so we will replace that number with new number
                */

                lIS.set( lowerBoundIndex , heightArray[i]);
            }
            else{
                /* 
                when there is a no number present in list lIS : which is greater than or equal to current number
                so we will add new number in list lIS
                */
                lIS.add(heightArray[i]);
            }
        }

        return lIS.size();
    }

    public int getLowerBoundIndex(int target){
        int start = 0;
        int end = lIS.size() - 1;
        int result= -1;

        while(start <=  end){
            int mid = start +((end-start)/2);

            if(lIS.get(mid) >= target){
                result = mid;
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }

        return result;
    }
}