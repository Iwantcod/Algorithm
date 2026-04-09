// 11:09

import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long l = 1L;
        long r = 1_000_000_000_000_000_000L;
        
        long answer = r;
        while(l <= r) {
            long mid = (l + r) / 2;
            long tmp = 0L;
            for(int i = 0; i < times.length; i++) {
                tmp += mid / times[i];
                if(tmp > n) {
                    break;
                }
            }
            if(tmp >= n) {
                answer = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        
        return answer;
    }
}