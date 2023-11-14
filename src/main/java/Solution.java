import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[] A = {3, 0, 5};
        String a = "abcd";
        String b = "dbcae";
        Solution solution = new Solution();
        solution.solution5(a, b);

    }

    public String solution(String message, int K) {
        // write your code in Java SE 11
        int len = message.length();
        if (K >= len) {
            return message;
        }

        String newmsg = message.substring(0, K);
        if (message.charAt(K) == ' ') {
            return newmsg;
        }
        String res = "";
        for (int i = newmsg.length() - 1; i >= 0; i--) {
            if (newmsg.charAt(i) == ' ') {
                res = newmsg.substring(0, i);
                break;
            }
        }

        return res;
    }

    public int solution1(int[] P, int[] S) {
        // write your code in Java SE 8
        int people_sum = Arrays.stream(P).reduce(0, Integer::sum);
        int[] newS = Arrays.stream(S).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();

        int sum = 0;
        int res = 0;
        for (int j = 0; j < newS.length; j++) {
            sum = sum + newS[j];
            if (sum >= people_sum) {
                res = ++j;
            }

        }
        return res;
    }

    public int solution3(int[] A) {
        double pollution_sum = Arrays.stream(A).reduce(0, Integer::sum) / 2.0;
        int temp = 0;
        int[] newA = Arrays.stream(A).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
        double[] doubles = Arrays.stream(newA).asDoubleStream().toArray();

        int counter = 0;
        double temp_sum = Integer.MAX_VALUE;
        while (temp_sum > pollution_sum) {
            doubles[0] = doubles[0] / 2;
            temp_sum = Arrays.stream(doubles).sum();
            counter++;
            if (doubles[0] < doubles[1]) {
                doubles = Arrays.stream(doubles).boxed().sorted(Collections.reverseOrder()).mapToDouble(Double::doubleValue).toArray();
            }

        }
        return counter;
    }

    public int solution4(String digits, String num) {
        char[] chars = num.toCharArray();
        int lastindex = 0;
        int count = 0;
        for (char c : chars) {
            int index = digits.indexOf(c);
            count = count + Math.abs(index - lastindex);
            lastindex = index;
        }
        return count;

    }

    public char solution5(String s, String t) {
        List<Character> list = new ArrayList<>();
        for (char ch : t.toCharArray()) {
            list.add(ch);
        }
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (list.contains(s.charAt(i))) {
                list.remove(c);
            }
        }
        return list.get(0);


    }


}
