class Solution {
    public int solution(int n) {
        int nCnt = count(n);
        while(true) {
            if(nCnt == count(++n))
                return n;
        }
    }
    public static int count(int num) {
        int cnt = 0;
        while(num >= 2) {
            if(num % 2 == 1)
                cnt++;
            num /= 2;
        }
        if(num == 1)
            cnt++;
        return cnt;
    }
}
