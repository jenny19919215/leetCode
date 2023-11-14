package hsbc;

public class UncommonCount {

    public static int countUncommon(int a[], int b[]) {
        int n1 = a.length;
        int n2 = b.length;
        int count = 0;
        for (int i = 0; i < n1; i++) {
            int flag = 0;
            for (int j = 0; j < n2; j++) {
                if (a[i] == b[j]) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                count++;
            }
        }
        for (int i = 0; i < n2; i++) {
            int flag = 0;
            for (int j = 0; j < n1; j++) {
                if (b[i] == a[j]) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 1, 2, 3, 4, 5, 5, 7, 6, 9, 10};
        int[] b = new int[]{11, 12, 13, 4, 5, 6, 7, 18, 19, 20};
        System.out.println(countUncommon(a, b));

    }
}
