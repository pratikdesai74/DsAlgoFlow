class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int right=0;
        int maxWeight=0;

        for(int weight:weights){
            maxWeight=Math.max(weight,maxWeight);
            right+= weight;
        }
        int left=maxWeight;

        //System.out.println("right: "+right);

        while(left <= right){
            int mid=(left + right)/2;
            //System.out.println("left: "+left+":: right: "+right+" | mid: "+mid);

            if(daysRequired(weights,mid)>days){
                left=mid+1;
            }
            else{
                right=mid-1;
                maxWeight= mid;
                //System.out.println("max weight: "+maxWeight);
            }
        }

        return maxWeight;
    }

    public int daysRequired(int[]weights,int maxWeight){
        //System.out.println(".......................");
        int tempSum=0;
        int currentDays=0;
        int i=0;
        while(i<weights.length){
            tempSum+=weights[i];
            //System.out.println("i: "+i+":: weights[i]: "+weights[i]+" | tempSum: "+tempSum);
            if(tempSum>maxWeight){
                currentDays++;
                //System.out.println("tempSum: "+tempSum+":: maxWeight: "+maxWeight+" | days:"+currentDays);
                tempSum=0;
                continue;
            }
            else if(tempSum==maxWeight){
                currentDays++;
                //System.out.println("tempSum: "+tempSum+":: maxWeight: "+maxWeight+" | days:"+currentDays);
                tempSum=0;
            }
            else if(i ==(weights.length-1)){
                currentDays++;
                //System.out.println("tempSum: "+tempSum+":: maxWeight: "+maxWeight+" | days:"+currentDays);
            }
            i++;
        }
        
        //System.out.println("-------------for mid: "+maxWeight+" :: currentDays: "+currentDays+" :----------------------");

        return currentDays;    
    }
}