import java.util.*;

class Solution {
    public int solution(int n) {
        long mod = 1000000007;
        long[] result = new long[5001]; // 2 ~ 5000
        result[2] = 3; result[4] = 11; result[6] = 41;
        for(int i = 8; i < 5001; i += 2) {
            result[i] = ((result[i-2] * 4 % mod) - (result[i-4] % mod) + mod) % mod;
        }
        return (int)result[n];
    }
}