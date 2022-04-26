package DoublePointer;
//https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/5v8a6t/
class Exchange {
    public static void main(String[] args){
        int[] nums = new int[]{1,2,3,4};
        Exchange exchange = new Exchange();
        System.out.println(exchange.exchange(nums));
    }

    public int[] exchange(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while (i<j){
            while(i<j && nums[i]%2 !=0) i++;
            while(j>i && nums[j]%2 ==0) j--;
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;j--;

        }
        return nums;
    }
}