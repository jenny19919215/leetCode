package hsbc;

import java.util.Scanner;

public class SecretMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numP = scanner.nextInt();
        int numQ = scanner.nextInt();

        int xorResult = numP ^ numQ;
        int bitCount = countSetBits(xorResult);

        System.out.println(bitCount);

        scanner.close();
    }

    public static int countSetBits(int num) {
        int count = 0;
        while (num > 0) {
            count += num & 1;
            num >>= 1;
        }
        return count;
    }
}
