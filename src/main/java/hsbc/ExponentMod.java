package hsbc;

public class ExponentMod {

    public static int modExp(int base, int exponent, int modulus) {
        int res = 1;
        base = base % modulus;
        while (exponent > 0) {
            if ((exponent & 1) == 1) res = (res * base) % modulus;

            base = (base % modulus) * (base % modulus) % modulus;
            exponent >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {

        int a = 2, b = 3, c = 4;
        // int a1 = 1023521456;
        // int b1=2036521456;
        // int c1 = a1*b1;
        //    long encryptedCode = modExp(modExp(a, b, 10), c, 1000000007);
        //    System.out.println(encryptedCode);

        int a1 = 2, b1 = 5;
        int res = 1;
        int fac = a1;
        while (true) {
            if ((b1 & 1) == 1) {
                res = res * fac;
            }
            fac = fac * fac;
            b1 = b1 / 2;
            if (b1 == 0) {
                break;
            }
        }
        System.out.println(res);

    }
}
