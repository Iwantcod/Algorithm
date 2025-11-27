// 23:42
class Solution {
    public int solution(int[] stones, int k) {
        int l = 0;
        int r = 200_000_001;
        int answer = 0;
        
        while(l <= r) {
            int mid = (l + r) / 2;
            int cnt = 0;
            boolean possible = true;
            for(int i = 0; i < stones.length; i++) {
                int cur = stones[i] - mid;
                if(cur < 0) {
                    cnt++;
                } else {
                    cnt = 0;
                }
                if(cnt == k) {
                    possible = false;
                    break;
                }
            }
            // System.out.println("l: "+l+" r: "+r);
            // System.out.println(mid+" "+possible);
            if(possible) {
                answer = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return answer;
    }
}