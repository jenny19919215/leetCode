package hsbc;

import java.util.Arrays;

public class LockKey {
    public static long unlockingKey(long key) {
        int count = 0;
        long answer = 0;
        // Write your code here
        String s = String.valueOf(key);
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length() - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    char temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        if (arr[0] == '0') {
            for (int j = 1; j < s.length(); j++) {
                if (arr[j] != '0') {
                    char temp = arr[j];
                    arr[j] = arr[0];
                    arr[0] = temp;
                    break;
                }
            }
        }

        answer = Long.parseLong(new String(arr));

        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        long l = unlockingKey(130);
    }

}
