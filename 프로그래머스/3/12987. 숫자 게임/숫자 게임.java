// 21:36
import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int indxA = 0;
        int indxB = 0;
        
        int answer = 0;
        while(indxB < B.length) {
            if(B[indxB] > A[indxA]) {
                answer++;
                indxA++;
            }
            indxB++;
        }
        
        return answer;
    }
}