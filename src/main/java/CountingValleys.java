import java.io.*;

class Result {

    /*
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     */

    public static int countingValleys(int steps, String path) {
        // Write your code here
        if (path == null) return 0;
        int sum = 0, num = 0;
        int d = 'b' - 'a';
        for (int i = 0; i < path.length(); i++) {
            char c = path.charAt(i);
            if (c == 'U') {
                sum++;
            } else if (c == 'D') {
                sum--;
            }

            if (sum == 0 && i > 0 && path.charAt(i - 1) == 'U') {
                num++;
            }

        }

        return num;

    }

}

public class CountingValleys {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int steps = Integer.parseInt(bufferedReader.readLine().trim());
        Integer a = 3;
        Integer b = 4;
        Integer c = 5;
        a = b;
        b = c;


        String path = bufferedReader.readLine();

        int result = Result.countingValleys(steps, path);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
