import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class Test1 {
    static int cost = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Character a = 'a';
        Character b = 'b';
        int n = a.compareTo(b);
        int[][] houses = new int[2][2];
        Arrays.sort(houses, Comparator.comparingInt(a2 -> a2[1]));

        int i = -1, j = -1;
        n = i ^ j;
        long l = 1;
        String s = String.valueOf(l);

        System.out.println(n);
    }


    static void dfs(int index, int[] need, int[] money, int[][] taoCangs, int val) {
        boolean isAllZero = Arrays.stream(need).allMatch(num -> num == 0);
        if (isAllZero) {
            cost = Math.min(cost, val);
        }
        for (int i = index; i < taoCangs.length; i++) {
            int[] array = taoCangs[i];
            boolean pass = IntStream.range(0, need.length).allMatch(j -> need[j] >= array[j]);
            if (!pass) {
                continue;
            }
            IntStream.range(0, need.length).forEach(j -> need[j] -= array[j]);
            dfs(i, need, money, taoCangs, val + money[i]);
            IntStream.range(0, need.length).forEach(j -> need[j] += array[j]);
        }
    }

}
