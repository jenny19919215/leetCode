public class MaximumBinaryString {

    public String maximumBinaryString(String binary) {
        int len = binary.length();
        if (len < 2) return binary;
        char[] chars = binary.toCharArray();
        int num0 = 0;
        int num1 = 0;
        int o = 0;
        if (binary.charAt(o) == '1') {
            while (o < len) {
                if (binary.charAt(o) == '1') {
                    o++;
                } else {
                    break;
                }

            }
        }
        if (o == len) return binary;


        int l = o;
        while (l < len) {
            if (chars[l] == '1') {
                num1++;
            } else {
                num0++;
            }
            l++;
        }
        if (num0 < 2) return binary;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num0 - 1; i++) {
            sb.append('1');
        }
        sb.append('0');
        for (int j = 0; j < num1; j++) {
            sb.append('1');
        }
        if (o == 0) {
            return sb.toString();
        } else return binary.substring(0, o) + sb.toString();

    }
}
