package DoublePointer;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TwoSum {
    static int f(int a, int bn) {
        int t = 1, y = a;
        while (bn > 0) {
            if ((bn & 1) == 1) t = t * y;
            y *= y;
            bn >>= 1;
        }
        return t;
    }

    public static void main(String[] args) {
        double a = Math.floor(3.6);
        int res = f(2, 10);
        int i = 5 / 2;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("一十九");
        stringBuffer.substring(1, stringBuffer.length());
        String ab = "一万零千零";
        String output = ab.replaceAll("零[千百十]", "零").replaceAll("零+", "零");
        String out = output.endsWith("零") ? output.substring(0, output.length() - 1) : output;
        Map<String, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(2);
        pq.offer(1);

        pq.peek();

        double b = Math.ceil(3.6);
        System.out.println(a + "" + b);
    }

    // https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/description/?utm_source=LCUS&utm_medium=ip_redirect&utm_campaign=transfer2china
    // 167
    public int[] twoSum(int[] numbers, int target) {

        if (numbers == null) return null;
        int size = numbers.length;
        int i = 0, j = size - 1;
        while (i < j) {
            if (numbers[i] + numbers[j] == target) {
                return new int[]{++i, ++j};
            } else if (numbers[i] + numbers[j] > target) {
                j--;
            } else {
                i++;
            }
        }


        return new int[]{++i, ++j};
    }

}
