import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean[] arr = new boolean[200_001];
        for(int i = 2; i * i <= 200000; i++) {
            for(int j = i * 2; j <= 200000; j += i) {
                arr[j] = true;
            }
        }
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int a = Integer.parseInt(input[1]);
        int b = Integer.parseInt(input[2]);
        int[][] map = new int[2][n];
        for(int i = 0; i < 2; i++) {
            String[] sp = br.readLine().split(" ");
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(sp[j]);
            }
        }

        long[] dp = new long[n];
        dp[0] = arr[map[0][0] + map[1][0]] ? b : a;
        if(n == 1) {
            bw.write(String.valueOf(dp[0]));
            bw.close();
            return;
        }
        dp[1] = Math.max(dp[0] + (arr[map[0][1] + map[1][1]] ? b : a), (arr[map[0][0] + map[0][1]] ? b : a) + (arr[map[1][0] + map[1][1]] ? b : a));
        int i = 2;
        while(i < n) {
            long case1 = dp[i-1] + (arr[map[0][i] + map[1][i]] ? b : a);
            long case2 = dp[i-2] + (arr[map[0][i] + map[0][i-1]] ? b : a) + (arr[map[1][i] + map[1][i-1]] ? b : a);
            if(case1 >= case2) {
                dp[i] = case1;
            } else {
                dp[i] = case2;
            }
            i++;
        }
        bw.write(String.valueOf(dp[n-1]));
        bw.close();
    }
}