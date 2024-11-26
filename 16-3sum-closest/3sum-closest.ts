function threeSumClosest(nums: number[], target: number): number {
    nums.sort((a,b) => a-b) //sort array w.r.t ascending order.

    //if want 3-nos combination from array in any order.
    //run i=0 - i<n-2 & 2-ptr l,r
    const n = nums.length;
    let closestSum = Infinity;
    for(let i=0; i<n-2; i++) {

        let l = i+1;
        let r = n-1;
        while(l<r) {
            let currSum = nums[i] + nums[l] + nums[r];

            if(Math.abs(target - currSum) < Math.abs(target-closestSum)) {
                closestSum = currSum;
            }

            if(currSum < target) l++;
            else if(currSum > target) r--;
            else return currSum;
        }
    }
    return closestSum;
};