package hsbc;

import java.util.*;
import java.util.stream.Collectors;

public class MaxOutlets {
    public static int maxOutlets(int num, int[] reqOutletsIDs, int[][] roadCon) {

        Map<Integer, List<Integer>> add = new HashMap<>();
        for (int i = 0; i < roadCon.length; i++) {
            List<Integer> list = add.getOrDefault(roadCon[i][0], new ArrayList<>());
            list.add(roadCon[i][1]);
            add.put(roadCon[i][0], list);

            List<Integer> list1 = add.getOrDefault(roadCon[i][1], new ArrayList<>());
            list1.add(roadCon[i][0]);
            add.put(roadCon[i][1], list1);
        }
        int finalRes = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i : reqOutletsIDs) {
            int res = 1;
            if (add.get(i) == null || add.get(i).isEmpty()) {
                continue;
            }
            queue.add(i);
            while (!queue.isEmpty()) {
                int size = queue.size();
                boolean flag = false;
                for (int in = 0; in < size; in++) {
                    Integer ele = queue.poll();
                    List<Integer> list = add.get(ele);
                    for (Integer eleToAdd : list) {
                        queue.offer(eleToAdd);
                        //remove edge for eleToAdd
                        List<Integer> l = add.get(eleToAdd);
                        l.remove(ele);
                        add.put(eleToAdd, l);

                        List<Integer> integerList = Arrays.stream(reqOutletsIDs).boxed().collect(Collectors.toList());

                        if (integerList.contains(eleToAdd)) {
                            flag = true;
                        }
                    }
                }
                if (flag) {
                    res++;
                }

            }

            finalRes = Math.max(finalRes, res);


        }

        return finalRes;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();

        int reqOutletsIDs_size = in.nextInt();
        int reqOutletsIDs[] = new int[reqOutletsIDs_size];
        for (int idx = 0; idx < reqOutletsIDs_size; idx++) {
            reqOutletsIDs[idx] = in.nextInt();
        }
        int numRoad = in.nextInt();
        int conOutlet = in.nextInt();
        int[][] roadCon = new int[numRoad][conOutlet];
        for (int i = 0; i < numRoad; i++) {
            for (int j = 0; j < conOutlet; j++) {
                roadCon[i][j] = in.nextInt();
            }
        }

        System.out.println(maxOutlets(num, reqOutletsIDs, roadCon));

    }
}
