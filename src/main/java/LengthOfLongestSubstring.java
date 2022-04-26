import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        int a = lengthOfLongestSubstring.lengthOfLongestSubstring2("abcabcbb");
        System.out.println("a is " + a);
    }

    //https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/5dgr0c/
    public int lengthOfLongestSubstring(String s) {//滑窗发 基本双指针 left指针逐个递增
        if (s == null || s.length() == 0) return 0;
        int max_length = 0;
        Set set = new HashSet<Character>();
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            set.clear();
            max_length = Math.max(j - i + 1, max_length);
            for (j = i; j < s.length(); j++) {
                if (set.contains(s.charAt(j))) {
                    break;
                } else {
                    set.add(s.charAt(j));
                    continue;
                }
            }
        }
        return max_length;
    }

    public int lengthOfLongestSubstring1(String s) {
        int max_length = 0;
        Map dic = new HashMap<Character, Integer>();
        int start = 0, end = 0;
        while (end < s.length()) {
            if (dic.containsKey(s.charAt(end))) {
                int index = (int) dic.get(s.charAt(end));
                int length = end - start;
                max_length = Math.max(max_length, length);
                end = start = index + 1;
                dic.clear();
            } else {
                dic.put(s.charAt(end), end);
                max_length = Math.max(max_length, end - start + 1);
                end++;
            }

        }

        return max_length;
    }

    public int lengthOfLongestSubstring2(String s) {
        int max_length = 0;
        Map dic = new HashMap<Character, Integer>();
        int start = 0, end = 0;
        for (;end < s.length();end++) {
            if (dic.containsKey(s.charAt(end))) {
                int index = (int) dic.get(s.charAt(end));
                start = Math.max(index + 1,start);
            }
            dic.put(s.charAt(end), end);
            max_length = Math.max(max_length, end - start + 1);
        }
        return max_length;
    }
}
