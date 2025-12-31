// 12:25
import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        int sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> {
            return i2 - i1;
        });
        for(int i = 0; i < works.length; i++) {
            sum += works[i];
            pq.add(works[i]);
        }
        if(sum <= n) {
            return 0;
        }

        while(n > 0) {
            int cur = pq.poll();
            pq.add(cur - 1);
            n--;
        }
        long answer = 0;
        while(!pq.isEmpty()) {
            long cur = pq.poll();
            answer += cur * cur;
        }
        
        return answer;
    }
}