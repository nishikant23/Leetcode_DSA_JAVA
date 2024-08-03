class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        for(int i=0; i<arr.length; i++){
            for(int j=i; j<arr.length; j++){
                if(target[i] == arr[j]){
                    swap(arr, i , j);
                    break;
                }
            }
        }

        for(int i=0; i<arr.length; i++){
            if(target[i] != arr[i]) return false;
        }
        return true; 
    }
    public void swap(int[] arr, int l, int r){
        int tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }
}


