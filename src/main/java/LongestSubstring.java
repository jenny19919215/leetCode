import java.util.HashSet;

// Java program to find the longest substring with k unique
// characters in a given string
//https://www.geeksforgeeks.org/find-the-longest-substring-with-k-unique-characters-in-a-given-string/?ref=lbp
class LongestSubstring {

    final static int MAX_CHARS = 26;

    // This function calculates number
    // of unique characters
    // using a associative array
    // count[]. Returns true if
    // no. of characters are less
    // than required else returns
    // false.
    static boolean isValid(int count[],
                           int k) {
        int val = 0;
        for (int i = 0; i < MAX_CHARS; i++) {
            if (count[i] > 0) {
                val++;
            }
        }

        // Return true if k is greater
        // than or equal to val
        return (k >= val);
    }

    // Finds the maximum substring
    // with exactly k unique chars
    static void kUniques(String s, int k) {
        int max_window_size = 0;
        int max_window_start = 0;

        int i = 0;
        int j = 0;
        while (i <= s.length() - k) {
            if (i + k + j <= s.length()) {
                String temp = s.substring(i, i + j + k);
                int count = calculateUniqueCarac(temp);
                if (count <= k) {
                    if (temp.length() > max_window_size) {
                        max_window_size = temp.length();
                        max_window_start = i;
                    }
                    j++;
                } else {
                    j = 0;
                    i++;
                }
            } else {
                i++;
                j = 0;
            }
        }
        System.out.println("Max substring is : "
                + s.substring(max_window_start,
                max_window_start + max_window_size)
                + " with length " + max_window_size);
    }

    private static int calculateUniqueCarac(String temp) {
        int count = 0;
        HashSet<String> set = new HashSet<>();
        for (char c : temp.toCharArray()) {
            if (!set.contains(String.valueOf(c))) {
                set.add(String.valueOf(c));
                count++;
            }
        }
        return count;
    }

    // Driver Code
    static public void main(String[] args) {
        String s = "aabbccdeeeeeeefs";
        int k = 3;
        kUniques(s, k);
    }
}

