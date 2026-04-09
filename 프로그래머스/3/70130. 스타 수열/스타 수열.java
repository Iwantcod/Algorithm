// 11:15
import java.util.*;
class Solution {
    public int solution(int[] a) {
        if(a.length <= 1) {
            return 0;
        }
        
        int[] cnt = new int[a.length];
        int[] lastIndx = new int[a.length];
        
        Arrays.fill(lastIndx, -1);
        
        if(a[0] != a[1]) {
            cnt[a[0]]++;
            lastIndx[a[0]] = 1;
        }
        
        for(int i = 1; i < a.length - 1; i++) {
            int cur = a[i];
            int prev = a[i-1];
            int next = a[i+1];
            if(cur != prev && lastIndx[cur] != i-1) {
                cnt[cur]++;
            } else if(cur != next) {
                cnt[cur]++;
                lastIndx[cur] = i+1;
            }
        }
        
        if(a[a.length - 1] != a[a.length - 2] && lastIndx[a[a.length - 1]] != a.length - 2) {
            cnt[a[a.length - 1]]++;
        }
        
        int answer = 0;
        for(int i = 0; i < cnt.length; i++) {
            // System.out.println(i+": "+cnt[i]);
            answer = Math.max(answer, cnt[i]);
        }
        answer *= 2;
        return answer;
    }
}