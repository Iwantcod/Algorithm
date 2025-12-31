// 11:54
import java.util.*;
class Solution {
    int[] kArr;
    int[][] reqs;
    int answer = Integer.MAX_VALUE;
    public int solution(int k, int n, int[][] reqs) {
        Arrays.sort(reqs, (r1, r2) -> {
            if(r1[2] == r2[2]) {
                return r1[0] - r2[0];
            } else {
                return r1[2] - r2[2];
            }
        });
        this.reqs = reqs;
        this.kArr = new int[k+1];
        Arrays.fill(kArr, 1);
        n -= k;
        // for(int i = 0; i < reqs.length; i++) {
        //     System.out.println(reqs[i][0]+" "+reqs[i][1]+" "+reqs[i][2]);
        // }
        dfs(n, 1);

        return answer;
    }
    public void dfs(int n, int depth) {
        if(n < 0) {
            return;
        }
        if(depth == kArr.length) {
            if(n == 0) {
                answer = Math.min(answer, cal());
            }
            return;
        }
        
        for(int i = 0; i <= n; i++) {
            kArr[depth] += i;
            dfs(n - i, depth + 1);
            kArr[depth] -= i;
        }
    }
    
    public int cal() {
        int indx = 0;
        int kIndx = 1;
        int[] kNext = new int[kArr[kIndx]];
        int wait = 0;
        while(indx < reqs.length) {
            if(reqs[indx][2] > kIndx) {
                kIndx++;
                kNext = new int[kArr[kIndx]];
            }
            
            boolean isFind = false;
            int minIndx = 0;
            int minVal = kNext[0];
            for(int i = 0; i < kNext.length; i++) {
                if(minVal > kNext[i]) {
                    minIndx = i;
                    minVal = kNext[i];
                }
                if(reqs[indx][0] >= kNext[i]) {
                    kNext[i] = reqs[indx][0] + reqs[indx][1];
                    isFind = true;
                    break;
                }
            }
            if(isFind == false) {
                wait += kNext[minIndx] - reqs[indx][0];
                kNext[minIndx] += reqs[indx][1];
            }
            indx++;
        }
        return wait;
    }

}