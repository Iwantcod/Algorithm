class Solution {
    public int solution(int n, int[] money) {
        long[] dp = new long[n+1];
        dp[0] = 1;
        
        // 이전 회차에 쌓였던 경우의 수를 모두 더한다.
        for(int i = 0; i < money.length; i++) {
            int cur = money[i];
            for(int j = cur; j < dp.length; j++) {
                dp[j] += dp[j - cur];
                dp[j] = dp[j] % 1_000_000_007;
            }
        }

        
        return (int)dp[n];
    }
}