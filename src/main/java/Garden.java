public class Garden {

    //https://leetcode-cn.com/problems/minimum-number-of-taps-to-open-to-water-a-garden/comments/
    //https://www.geeksforgeeks.org/count-minimum-number-of-fountains-to-be-activated-to-cover-the-entire-garden/
    public int minTaps(int n, int[] ranges) {
        int[][] realRange = new int[n + 1][2];
        for (int i = 0; i < n + 1; i++) {
            realRange[i] = new int[]{Math.max(0, i - ranges[i]), Math.min(i + ranges[i], n)};
        }
        int max_right = 0;
        int pos = 0;
        int max_left = 0;
        int count = 0;
        while (max_right < n) {
            for (int i = pos; i < n + 1; i++) {
                if (realRange[i][0] <= max_left) {
                    if (realRange[i][1] > max_right) {
                        //max_left = max_right;
                        max_right = realRange[i][1];
                        pos = i;
                    }
                }
            }
            if (max_right > max_left) {
                count++;
                max_left = max_right;
            } else {
                return -1;
            }
        }
        return count;
    }
}
