import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int mod = 1000000;
        String input = br.readLine();
        int[] dp = new int[input.length() + 1];
        dp[0] = 1;

        for(int i = 1; i < input.length() + 1; i++) {
            int now = input.charAt(i-1) - '0';
            if(now >= 1 && now <= 9) {
                dp[i] += dp[i-1];
            }
            
            if(i == 1) {
                continue;
            }

            int prev = input.charAt(i-2) - '0';
            if(prev == '0') {
                continue;
            }

            int val = prev*10 + now;
            if(val >= 10 && val <= 26) {
                dp[i] += dp[i-2];
                dp[i] %= mod;
            }
        }
        
        bw.write(String.valueOf(dp[dp.length - 1]));
        bw.close();
        
    }
}