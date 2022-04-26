package Greedy;

import java.util.Arrays;

public class FindMinArrowShots {

    public int findMinArrowShots(int[][] points) {
        if(points == null)return 0;
        Arrays.sort(points,(o1, o2) -> o1[1]<o2[1] ? -1 : o1[1] == o2[1] ?0:1);
        int end = points[0][1];
        int nb =1;
        int i=1;
        while(i<points.length){
            if(points[i][0] > end){
                end = points[i][1];
                nb++;

            }
            i++;
        }

        return nb;
    }
}
