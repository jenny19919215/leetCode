package Greedy;

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int sum =0; int max =nums[0];
        for(int i:nums){
            if(sum<0){
                sum = i;
            }else{
                sum = sum+i;
            }
            max = Math.max(max,sum);
        }
        return max;
    }

    public int maxSubArrayDP(int[] nums) {
        int sum =0;int max = nums[0];
        for(int i:nums){
            sum = Math.max(sum + i, i);
            max = Math.max(sum,max);
        }
        return max;
    }
}
