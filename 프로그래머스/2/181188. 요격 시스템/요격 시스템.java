import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        
        Arrays.sort(targets, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        
        int point = targets[0][1];
        int cnt = 1;
        
        for(int i = 0; i < targets.length; i++) {
            if(targets[i][0] >= point) {
                point = targets[i][1];
                cnt++;
            }
        }
        
        // for(int i = 0; i<targets.length; i++) {
        //     System.out.println(targets[i][0]+" "+targets[i][1]);
        // }
        return cnt;
    }
}