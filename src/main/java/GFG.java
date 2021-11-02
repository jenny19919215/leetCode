class GFG<Static> {

    // Function to find maximum
// length of normal subStrings
    static int maxNormalSubString(char[] P, char[] Q,
                                  int K, int N) {
        String word = String.valueOf(P);
        if (K == 0)
            return 0;

        // keeps count of normal characters
        int count = 0;

        // indexes of subString
        int left = 0, right = 0;

        // maintain length of longest subString
        // with at most K normal characters
        int ans = 0;


        while (left < N - 1 && right < N) {
            int number = findNormalCaracNum(word.substring(left, right + 1), Q);
            if (number <= K) {
                int length = right + 1 - left;
                if (length > ans) ans = length;
                right++;
            } else {
                left++;
                right = left;
            }
        }
        return ans;
    }

    private static int findNormalCaracNum(String s, char[] Q) {
        if (s == null) return 0;
        int num = 0;
        for (char c : s.toCharArray()) {
            int pos = c - 'a';
            if (Q[pos] == '0') {
                num++;
            }
        }
        return num;
    }

    // Driver code
    public static void main(String[] args) {
        // initialise the String
        String P = "giraiiffe", Q = "01111001111111111011111111";

        int K = 2;

        int N = P.length();

        System.out.print(maxNormalSubString(P.toCharArray(), Q.toCharArray(), K, N));
    }
}