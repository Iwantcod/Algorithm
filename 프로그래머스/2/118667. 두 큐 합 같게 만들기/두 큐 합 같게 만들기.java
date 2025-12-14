// 14:41
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int[] q1 = new int[queue1.length + queue2.length]; // q1 + q2
        int[] q2 = new int[queue1.length + queue2.length]; // q2 + q1
        long target = 0;
        long sum1 = 0;
        long sum2 = 0;
        for(int i = 0; i < queue1.length; i++) {
            target += queue1[i];
            target += queue2[i];
            sum1 += queue1[i];
            sum2 += queue2[i];
            
            q1[i] = queue1[i];
            q1[i + queue1.length] = queue2[i];
            q2[i] = queue2[i];
            q2[i + queue2.length] = queue1[i];
        }
        if(target % 2 != 0) {
            // 두 큐의 총합이 홀수이면 균등하게 분배 불가
            return -1;
        }
        target /= 2;
        
        if(sum1 > sum2) {
            return cal(q1, target, sum1);
        } else {
            return cal(q2, target, sum2);
        }
    }
    public int cal(int[] queue, long target, long sum) {
        int limit = queue.length * 3;
        int count = 0;
        int len = queue.length;
        int p = 0;
        int q = queue.length / 2 - 1;
        
        while(sum != target) {
            if(sum < target) {
                q = increaseIndex(len, q);
                sum += queue[q];
            } else if(sum > target) {
                sum -= queue[p];
                p = increaseIndex(len, p);
            }
            count++;
            if(count >= limit)
                return -1;
        }
        return count;
        
    }
    public int increaseIndex(int len, int i) {
        if(i + 1 == len) {
            return 0;
        } else {
            return i + 1;
        }
    }
}
