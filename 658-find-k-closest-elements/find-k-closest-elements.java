class Solution {
// 2 pointer :: T.C= O(n)

    // public List<Integer> findClosestElements(int[] arr, int k, int x) {
    //     int start=0,end=arr.length-1;

    //     while(end-start>=k){
    //         if(Math.abs(arr[start]-x) > Math.abs(arr[end]-x)){
    //             start++;
    //         }
    //         else{
    //             end--; 
    //         }
    //     }

    //     List<Integer> closestNums=new ArrayList<>(k);
    //     for(int i=start;i<=end;i++)
    //         closestNums.add(arr[i]);

    //     return closestNums;
    // }

//binary search + sliding window :: T.C= O(log(n-k))
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left=0,right=arr.length-k;

        while(left<right){
            int mid= (left+right)/2;

            if(x-arr[mid] > arr[mid+k]-x){
                left=mid+1;
            }
            else{
                right=mid; 
            }
        }

        List<Integer> closestNums=new ArrayList<>(k);
        for(int i=left;i<left+k;i++)
            closestNums.add(arr[i]);

        return closestNums;
    }
}