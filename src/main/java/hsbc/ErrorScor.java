package hsbc;

import java.util.ArrayList;
import java.util.List;

public class ErrorScor {

    public static int minProject(int[] errorScore, int comP, int othQ) {
        int num = 0;
        while (true) {
            int count = 0;
            int ind = findMaxValIndex(errorScore);
            for (int i = 0; i < errorScore.length; i++) {
                if (i == ind) {
                    errorScore[i] = errorScore[i] - comP < 0 ? 0 : errorScore[i] - comP;
                } else {
                    errorScore[i] = errorScore[i] - othQ < 0 ? 0 : errorScore[i] - othQ;
                }
            }

            num++;
            for (int e : errorScore) {
                if (e == 0) {
                    count++;
                }
            }

            if (count == errorScore.length) {
                break;
            }

        }

        return num;
    }

    private static int findMaxValIndex(int[] errorScore) {
        int ind = 0;
        int max = errorScore[0];
        for (int i = 1; i < errorScore.length; i++) {
            if (errorScore[i] > max) {
                max = errorScore[i];
                ind = i;
            }
        }

        return ind;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{6, 4, 1};
        int a = 9 / 5;
        System.out.println(minProject(arr, 4, 1));

        List l = new ArrayList();
        int count = l.size() / 5000;
        for (int i = 0; i < count; i++) {
            int index = i * 5000;
            List newl = l.subList(index, index + 5000);
        }

        l.subList(count * 5000, l.size());


    }
}
