package hsbc;

import java.util.Scanner;

public class BulbsOnOff {
    public static void main(String[] args) {
        int a = 0, b = 1, c = 2;
        if ((a = b = c) == 2) {
            System.out.println("dddd");
        }

        Scanner scanner = new Scanner(System.in);

        // Read input
        int N = scanner.nextInt();


        int[] states = new int[N];
        int[] distances = new int[N];

        for (int i = 0; i < N; i++) {
            states[i] = scanner.nextInt();
        }

        for (int i = 0; i < N; i++) {
            distances[i] = scanner.nextInt();
        }

        // Calculate and print the minimum cable length
        int result = minimumCableLength(N, states, distances);
        System.out.println(result);

        scanner.close();
    }

    static int minimumCableLength(int N, int[] states, int[] distances) {
        int totalCableLength = 0;
        int lastOnBulbIndex = -1;
        int lastOnBulbDistance = 0;
        int ind = -1;
        int count = 0;
        for (int i : states) {
            if (i == 1) {
                count++;
            }
        }
        if (count == states.length) {
            return 0;
        }

        for (int i = 0; i < N; i++) {
            if (states[i] == 1) {
                ind = i;
                lastOnBulbIndex = i;
                break;
            }
        }
        if (ind + 1 < N) {
            for (int i = ind + 1; i < N; i++) {
                if (states[i] == 0) {
                    int dis = Math.abs(distances[i] - distances[lastOnBulbIndex]);
                    totalCableLength += dis;
                }
                lastOnBulbIndex = i;
            }
        }
        lastOnBulbIndex = ind;
        if (ind > 0) {
            for (int i = ind - 1; i >= 0; i--) {
                if (states[i] == 0) {
                    int dis = Math.abs(distances[i] - distances[lastOnBulbIndex]);
                    totalCableLength += dis;
                }
                lastOnBulbIndex = i;
            }
        }

        return totalCableLength;
    }
}
