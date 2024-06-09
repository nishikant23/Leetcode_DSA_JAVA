class Solution {
    public int[] twoSum(int[] arr, int tar) {
        int l=0, r=arr.length-1;
        System.out.println("L is: "+l+" & R is: "+r+" & Target is: "+tar);
        while(l<r){
            int sum = arr[l]+arr[r];
             System.out.println("Sum is: "+sum);
            if(sum==tar) {
                return new int[] {l+1, r+1};
            }
            else if(sum > tar ) r--;
            //else l++;
            else if(sum < tar ) l++;

            System.out.println("L is: "+l+" & R is: "+r);
        }
        return new int[] {};
    }
}