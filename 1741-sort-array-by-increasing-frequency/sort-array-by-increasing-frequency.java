class Solution {
    class Pair{
        int num;
        int freq;
        Pair(int num, int freq){
            this.num = num;
            this.freq = freq;
        }
    }
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Pair[] pair = new Pair[nums.length];
        for(int n : nums) {
            map.put(n, map.getOrDefault(n, 0)+1);
        }
        for(int i=0; i<nums.length; i++){
            pair[i] = new Pair(nums[i], map.get(nums[i]));
        }
        Arrays.sort(pair, (a,b) -> {
            if(a.freq != b.freq)
               return a.freq - b.freq;
            else 
               return b.num - a.num;
        });
        //Debugging
        // for(int i=0; i<nums.length; i++){
        //     System.out.println("Num = "+pair[i].num+" Frequency = "+pair[i].freq);
        // }
        int[] sortedNums = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            sortedNums[i] = pair[i].num;
        }
        // int l=0, r=0;
        // for(int i=0; i<nums.length; i++){
        //     l=i;
        //     for(int j=i; j<pair.length; j++) {
        //         if(pair[i].freq != pair[j].freq){ 
                    
        //             r=j-1;
        //             i = j;
        //             break;
        //         }
        //     }
        //     sort(pair, l, r);
        // }
        return sortedNums;
    }
    public void sort(Pair[] pair, int l, int r){
        int[] arr = new int[r-l+1];
        for(int i=l; i<=r; i++){
            arr[i] = pair[i].num;
        }
        Arrays.sort(arr);
        for(int i=0; i<arr.length; i++){
            pair[i].num = arr[i];
        }
    }
}