class Solution {
    public int maxPoints(int[][] points) {
        Map<Double,Integer> slopeFrequency;
        int maxPoints=0;
        for(int i=0;i<points.length-1;i++){
            slopeFrequency=new HashMap<>();

            for(int j=i+1;j<points.length;j++){

                double yDiff=points[j][1] - points[i][1];
                double xDiff=points[j][0] - points[i][0];
                double slope=0.0;

                if(xDiff == 0){
                    //slope=points[j][0];
                    slope=-999999.0;
                }
                else if(yDiff == 0){
                    slope=points[j][1];
                }
                else slope=yDiff/xDiff;

                //System.out.println("i: "+i+"and j: "+j+":: slope:"+slope);
                slopeFrequency.put(slope,slopeFrequency.getOrDefault(slope,0)+1);

                maxPoints=Math.max(maxPoints,slopeFrequency.get(slope));
            }
        }

        return maxPoints+1;
    }
}