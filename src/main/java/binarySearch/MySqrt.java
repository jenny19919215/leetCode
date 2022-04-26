package binarySearch;

public class MySqrt {

    public static void main(String[] args){
        int a =2147483647;
        MySqrt mySqrt = new MySqrt();
        int b = mySqrt.mySqrt(a);
    }

    public int mySqrt(int x) { //69
        if(x <=1) return x;
        int l =0; int r = x;// not x+1 cause maybe overflow for the 2nd biggest int number,just 1 is the exception
        int m=0;
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
            if(letters[m]>target){
                r =m;
            }else{
                l=m+1;
            }
        }

        return l < letters.length? letters[l]:letters[0];
    }

    public int singleNonDuplicate(int[] nums) { //458
        int l = 0, h = nums.length-1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if ((m % 2 == 1 && nums[m] == nums[m - 1] )||(m%2 ==0 && nums[m] == nums[m+1])) {
                l =m+1;
            }else{
                h =m;
            }
        }
        return nums[l];
    }
}
