package hsbc;

import java.util.*;

public class CellState {

    public static int[] stateOfCellsHSBC(int[] cells, int days) {
        int[] res = cells;
        int[] lastStatus;
        for (int i = 0; i < days; i++) {
            lastStatus = Arrays.copyOf(res, res.length);
            for (int j = 0; j < cells.length; j++) {
                if (j == 0) {
                    res[j] = lastStatus[j + 1];
                    continue;
                }
                if (j == cells.length - 1) {
                    res[j] = lastStatus[j - 1];
                    continue;
                }
                if (lastStatus[j - 1] == lastStatus[j + 1]) {
                    res[j] = 0;
                } else {
                    res[j] = 1;
                }
            }

        }
        return res;
    }


    public static int[] stateOfCells(int[] cells, int N) {
        int len = cells.length;
        Map<Integer, int[]> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        int[] temp = next(cells, len);
        for (int i = 1; i <= N; i++) {
            String key = Arrays.toString(temp);
            if (set.contains(key)) break;
            set.add(key);
            map.put(i, temp);
            temp = next(temp, len);
        }
        int period = set.size();
        int day = N % period;
        return map.get(day == 0 ? period : day);
    }

    private static int[] next(int[] cur, int len) {
        int[] res = new int[len];
        for (int i = 1; i < len - 1; i++) {
            res[i] = (cur[i - 1] ^ cur[i + 1]) == 0 ? 0 : 1;
        }
        return res;
    }


    public static int[] prisonAfterNDays(int[] cell, int days) {
        // days = (days - 1) % 14 + 1;
        for (int i = 0; i < days; i++) {
            cell = cal(cell);
        }
        return cell;
    }

    public static int[] cal(int[] cells) {
        int[] array = new int[cells.length];
        for (int i = 1; i < cells.length - 1; i++) {
            if (cells[i - 1] == cells[i + 1]) {
                array[i] = 0;
            } else {
                array[i] = 1;
            }
        }
        return array;
    }


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int cell_size = in.nextInt();
        int cell[] = new int[cell_size];
        for (int idx = 0; idx < cell_size; idx++) {
            cell[idx] = in.nextInt();
        }

        int days = in.nextInt();
        int[] result = stateOfCellsHSBC(cell, days);
        for (int idx = 0; idx < result.length; idx++) {
            System.out.println(result[idx]);
        }

    }


}
