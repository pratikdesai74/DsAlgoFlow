class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int[] leftSmallest =new int[n];
        int[] rightSmallest =new int[n];

        Stack<Integer> leftSmallestStack=new Stack<>();
        Stack<Integer> rightSmallestStack=new Stack<>();

        //left closest smallest value's index
        for(int i=0;i<n;i++){
            while(!leftSmallestStack.empty() && heights[leftSmallestStack.peek()] >= heights[i]){
                leftSmallestStack.pop();
            }

            if(leftSmallestStack.empty()){
                leftSmallest[i]=-1;
            }
            else{
                leftSmallest[i]=leftSmallestStack.peek();
            }

            leftSmallestStack.push(i);
        }

        //right closest smallest value's index
        for(int i=n-1;i>=0;i--){
            while(!rightSmallestStack.empty() && heights[rightSmallestStack.peek()] >= heights[i]){
                rightSmallestStack.pop();
            }

            if(rightSmallestStack.empty()){
                rightSmallest[i]=n;
            }
            else{
                rightSmallest[i]=rightSmallestStack.peek();
            }

            rightSmallestStack.push(i);
        }

        int maxArea= Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
           maxArea=Math.max(maxArea, (rightSmallest[i]-leftSmallest[i]-1) * heights[i]); 
        }

        return maxArea;
    }
}