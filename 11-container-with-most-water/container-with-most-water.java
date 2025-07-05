class Solution {
    public int maxArea(int[] height) {
        int i=0,j=height.length-1;
        int maxArea=0;

        while(i<j){
            int length=Math.min(height[i],height[j]);
            int breadth=j-i;
            int area=length*breadth;

            maxArea=Math.max(maxArea,area);

            if(height[i]<height[j]){
                i++;
            }
            else{
                j--;
            }
        }   

        return maxArea;
    }
}