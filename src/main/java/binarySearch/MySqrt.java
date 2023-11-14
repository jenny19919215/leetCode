package binarySearch;

public class MySqrt {

    public static void main(String[] args) {
        int a = 2147483647;
        MySqrt mySqrt = new MySqrt();
        //   int b = mySqrt.mySqrt(a);
        int[] array = new int[]{1, 2, 6, 7};
        int c = findLowerClosest(array, 3);
    }

    public static int findLowerClosest(int[] A, int target) {
        // find the last element smaller than target
        long l = 1000l;
        int a = (int) (l % 10);
        int start = 0, end = A.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        if (A[end] < target) {
            return end;
        }
        if (A[start] < target) {
            return start;
        }

        return -1;
    }

    public int mySqrt(int x) { //69
        if (x <= 1) return x;
        int l = 0;
        int r = x;// not x+1 cause maybe overflow for the 2nd biggest int number,just 1 is the exception
        int m = 0;
        while (l<r){
            m = l+(r-l)/2;
            if(x/m < m){
                r =m;
            }else{
                l=m+1;
            }
        }
        return l-1;
    }

    public char nextGreatestLetter(char[] letters, char target) { //744
        int l =0; int r = letters.length;
        int m=0;
        while(l<r){
            m = l+(r-l)/2;
            if (letters[m] > target) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return l < letters.length ? letters[l] : letters[0];
    }

    public int singleNonDuplicate(int[] nums) { //458
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if ((m % 2 == 1 && nums[m] == nums[m - 1]) || (m % 2 == 0 && nums[m] == nums[m + 1])) {
                l = m + 1;
            } else {
                h = m;
            }
        }
        return nums[l];
    }
}
