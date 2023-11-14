package DoublePointer;

public class ValidPalindrome {

    public boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        for (; i <= j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return isPalidrome(s, i + 1, j) || isPalidrome(s, i, j - 1);
            }
        }
        return true;

    }

    private boolean isPalidrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }


}
