class Solution {
    public int solution(int[] s, int k) {
        int left = 0;
        int right = 200_000_000;
        
        while(left <= right) {
            int mid = (left + right) / 2;
            if(check(mid, s, k)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
    public boolean check(int mid, int[] s, int k) {
        int cnt = 0;
        for(int i = 0; i < s.length; i++) {
            if(s[i] - mid <= 0) {
                cnt++;
            } else {
                cnt = 0;
            }
            if(cnt >= k) {
                return false;
            }
        }
        return true;
    }
    
}