// 21:09
class Solution {
    public int solution(int[] stones, int k) {
        int p = 0;
        int q = 400_000_001;
        int answer = 0;
        
        while(p < q) {
            int mid = (p+q)/2;
            // System.out.println(mid);
            if(possible(mid, k, stones)) {
                answer = mid;
                p = mid + 1;
            } else {
                q = mid;
            }
        }

        return answer;
    }
    public boolean possible(int n, int k, int[] stones) {
        int cnt = 0;
        for(int i = 0; i < stones.length; i++) {
            if(stones[i] - n < 0) {
                cnt++;
            } else {
                cnt = 0;
            }
            if(cnt == k) {
                return false;
            }
        }
        return true;
    }
}