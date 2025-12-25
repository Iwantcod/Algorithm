// 16:35
import java.util.*;
class Solution {
    int[] kArr;
    int[][] reqs;
    int answer;
    public int solution(int k, int n, int[][] reqs) {
        this.kArr = new int[k+1];
        this.answer = Integer.MAX_VALUE;
        this.reqs = reqs;
        Arrays.fill(kArr, 1);
        n -= k;
        Arrays.sort(reqs, (r1, r2) -> {
            if(r1[2] == r2[2]) {
                return r1[0] - r2[0];
            } else {
                return r1[2] - r2[2];
            }
        });
        
        dfs(n, 1);
        return answer;
    }
    public void dfs(int n, int depth) {
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
        int cnt = 0;
        int indx = 0;
        for(int i = 1; i < kArr.length; i++) {
            int[] next = new int[kArr[i]];
            while(indx < reqs.length) {
                int[] cur = reqs[indx];
                if(cur[2] != i) {
                    break;
                }
                indx++;
                boolean isWait = true;
                int minIndx = -1;
                int minVal = Integer.MAX_VALUE;
                for(int j = 0; j < next.length; j++) {
                    if(next[j] < minVal) {
                        // 대기시간 측정을 위한 '다음 상담 가능 시간이 가장 이른' 멘토 기록
                        minIndx = j;
                        minVal = next[j];
                    }
                    
                    if(next[j] <= cur[0]) {
                        // 대기시간이 필요없는 경우 해당 멘토의 '다음 상담 가능 시간'을 갱신
                        isWait = false;
                        next[j] = cur[0] + cur[1];
                        break;
                    }
                }
                if(isWait == true) {
                    cnt += next[minIndx] - cur[0];
                    next[minIndx] += cur[1];
                }
            }
        }
        return cnt;
    }
}