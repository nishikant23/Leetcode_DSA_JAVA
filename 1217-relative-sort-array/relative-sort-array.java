class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int max=0;
        for(int i=0; i<arr1.length; i++){
            max = Math.max(max, arr1[i]);
        }
        int[] cnt = new int[max+1];
        for(int i=0; i<arr1.length; i++){
            cnt[arr1[i]]++;
        }
        //Uncommnet check cnt array elements
        // for(int i=0; i<cnt.length; i++){
        //    System.out.println("Count["+i+"] = "+cnt[i]);
        // }
        int[] ans = new int[arr1.length];
        int index = 0;
        for(int i=0; i<arr2.length; i++){
            while(cnt[arr2[i]]>0) {
                ans[index] = arr2[i];
                index++;
                cnt[arr2[i]]--; //makes changes in cnt-array itself
            }
        }
        // for(int i=0; i<cnt.length; i++){
        //    System.out.println("Count["+i+"] = "+cnt[i]);
        // }
        for(int i=0; i<cnt.length; i++){
           
            while(cnt[i]>0) {
                ans[index] = i;
                index++;
                cnt[i]--;
            }
        }
        // for(int i=0; i<cnt.length; i++){
        //    System.out.println("Count["+i+"] = "+cnt[i]);
        // }
        return ans;
    }
}