// 09:37
class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        int n = t.length;
        long p = 0;
        long q = 400_000_000_000_000L;
        long answer = 0;
        while(p < q) {
            long mid = (p+q)/2;
            long totalG = 0;
            long totalS = 0;
            long total = 0;
            for(int i = 0; i < n; i++) {
                long time = mid/(t[i]*2);
                if(mid % (t[i]*2) >= t[i]) {
                    time++;
                }
                long curG = Math.min(g[i], w[i] * time);
                long curS = Math.min(s[i], w[i] * time);
                totalG += curG;
                totalS += curS;
                total += Math.min(g[i] + s[i], w[i] * time);
            }
            if(total >= a + b && totalG >= a && totalS >= b) {
                answer = mid;
                q = mid;
            } else {
                p = mid + 1;
            }
        }
        
        return answer;
    }
}