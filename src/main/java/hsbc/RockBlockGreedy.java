package hsbc;

public class RockBlockGreedy {
    //https://www.geeksforgeeks.org/find-maximum-height-pyramid-from-the-given-array-of-objects/

    public static int heightPyramid(int[] arr) {
        int answer = 0;

        int next = 1;

        for (int i = 0; i < arr.length; ) {

            answer++;
            next++;
            i = i + next;


        }


        return answer;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{20, 40, 30, 100, 120, 10, 23, 1, 2, 3};
        System.out.println(heightPyramid(arr));
    }
}
