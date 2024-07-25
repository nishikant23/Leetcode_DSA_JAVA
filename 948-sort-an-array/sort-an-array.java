class Solution {
    public int[] sortArray(int[] nums) {
        int n=nums.length;
        PriorityQueue<Integer> pq  =new PriorityQueue<>();
        for(int i=0; i<n; i++) pq.add(nums[i]);
        int[] res = new int[n];
        for(int i=0; i<n;i++){
            res[i] = pq.poll();
        }
        return res;
        // for(int i=0; i<n-1;i++){
        //     for(int j=i+1; j<n; j++){
        //         if(nums[i] > nums[j]){
        //             swap(i, j, nums);
        //         }
        //     }
        // }
        // return nums;
    }
    // public void swap(int i, int j, int[] arr) {
    //     int temp = arr[i];
    //     arr[i] = arr[j];
    //     arr[j] = temp;
    // }
}