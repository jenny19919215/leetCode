//https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/99wd55/
class DPpractice {
    public int translateNum(int num) {
        char[] nums = String.valueOf(num).toCharArray();
        //int[] dp = new int[nums.length];
        // dp[0] = 1;
        // here a = dp[i-2], b = dp[i-1], c = dp[i]
        int a = 1;
        int b, c = 0;
        if (nums.length == 1) {
            return a;
        }
        if (!canBeTranslated(nums[0], nums[1])) {
            b = 1;
        } else b = 2;
        if (nums.length == 2) {
            return b;
        }
        for (int i = 2; i < nums.length; i++) {
            if (!canBeTranslated(nums[i - 1], nums[i])) {
                c = b;
            } else {
                c = a + b;
            }
            a = b;
            b = c;
        }
        return c;
    }

    private boolean canBeTranslated(char num, char num1) {
        Integer integer = Integer.valueOf(String.valueOf(num).concat(String.valueOf(num1)));
        if (integer.intValue() > 9 && integer.intValue() < 26) {
            return true;
        }
        return false;
    }


}