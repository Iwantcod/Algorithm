// 22:32
import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int answer = 0;
        int len = A.length;
        
        int aIndx = 0;
        int bIndx = 0;
        
        while(bIndx < len) {
            if(B[bIndx++] > A[aIndx]) {
                aIndx++;
                answer++;
            }
        }
        
        return answer;
    }
}