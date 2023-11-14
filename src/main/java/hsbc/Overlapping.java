package hsbc;

import javafx.util.Pair;

import java.util.*;

public class Overlapping {


    /*  public static void main(String[] args) {
          Scanner scanner = new Scanner(System.in);
          int n = scanner.nextInt();
          int num = scanner.nextInt();
          List<Pair> v = new ArrayList<>();


          for (int i = 0; i < n; i++) {
              int u = scanner.nextInt();
              int w = scanner.nextInt();
              v.add(new Pair(u, w));
          }
          v.sort((p1, p2) -> (Integer) p2.getKey() - (Integer) p1.getKey());

          Stack<Pair> st = new Stack<>();
          for (int i = 0; i < v.size(); i++) {
              st.push(v.get(i));
          }

          int count = 0;
          while (!st.isEmpty()) {
              Pair y = st.pop();
              count++;
              if (!st.isEmpty()) {
                  if ((Integer)y.getValue() >= (Integer)st.peek().getKey()) {
                      st.pop();
                  }
              }
          }

          System.out.println(count);
      }*/
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // input for busStops
        int busStops_row = in.nextInt();
        int busStops_col = in.nextInt();
        int busStops[][] = new int[busStops_row][busStops_col];
        for (int idx = 0; idx < busStops_row; idx++) {
            for (int jdx = 0; jdx < busStops_col; jdx++) {
                busStops[idx][jdx] = in.nextInt();
            }
        }

        int result = distanceCovered(busStops);
        System.out.print(result);

    }


    public static int distanceCovered(int[][] busStops) {
        List<Pair<Integer, Integer>> v = new ArrayList<>();
        for (int i = 0; i < busStops.length; i++) {
            if (busStops[i][0] < busStops[i][1]) {
                v.add(new Pair(busStops[i][0], busStops[i][1]));
            } else {
                v.add(new Pair(busStops[i][0], busStops[i][1]));
            }
        }

        v.sort((p1, p2) -> (int) p1.getKey() - (int) p2.getKey() == 0 ? (int) p1.getValue() - (int) p2.getValue() : (int) p1.getKey() - (int) p2.getKey());
        int total = 0, dis = 0;

        for (int i = 0; i < v.size(); i++) {
            dis = (int) v.get(i).getValue() - (int) v.get(i).getKey();
            if (i > 0) {
                if (v.get(i).getKey() <= v.get(i - 1).getValue()) {
                    dis = v.get(i).getValue() - v.get(i - 1).getValue();
                }
            }
            total = total + dis;
        }


        Queue<Pair> st = new LinkedList<>();
        for (int i = 0; i < v.size(); i++) {
            st.offer(v.get(i));
        }

        int count = 0;
        while (!st.isEmpty()) {
            Pair y = st.poll();
            int unitDis = (int) y.getValue() - (int) y.getKey();
            if (!st.isEmpty()) {
                if ((Integer) y.getValue() >= (Integer) st.peek().getKey()) {
                    unitDis = (Integer) st.peek().getValue() - (Integer) y.getKey();
                    st.poll();
                }
            }
            count = count + unitDis;
        }


        return count;
    }

}

