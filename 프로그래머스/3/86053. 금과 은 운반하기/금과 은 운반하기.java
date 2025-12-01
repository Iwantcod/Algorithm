class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long l = 0L;
        long r = 1L;
        while(check(a, b, g, s, w, t, r) == false) {
            l = r;
            r *= 2;
        }
        while(l < r) {
            long mid = (l + r) / 2;
            if(check(a, b, g, s, w, t, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        
        return r;
    }
    public boolean check(int a, int b, int[] g, int[] s, int[] w, int[] t, long target) {
        int n = w.length;
        long total = 0L;
        long totalG = 0L;
        long totalS = 0L;
        
        for(int i = 0; i < n; i++) {
            // 최대 왕복 횟수 구하기 -> 최대 운반 가능량 구하기
            // 1. 해당 시간에 최대 운반 가능량 구하기
            long cnt = target / (t[i] * 2);
            if(target % (t[i] * 2) >= t[i]) {
                cnt++;
            }
            long curMax = Math.min(cnt * w[i], g[i] + s[i]);
            total += curMax;
            // 2. 금만 옮기는 경우의 운반량 구하기
            totalG += Math.min(curMax, g[i]);
            // 3. 은만 옮기는 경우의 운반량 구하기
            totalS += Math.min(curMax, s[i]);
        }
        if(total >= a + b && totalG >= a && totalS >= b) {
            return true;
        }
        return false;
    }
}