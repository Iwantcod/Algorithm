import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1]; // 특정 수의 제곱수 조합 최소값을 저장
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for(int j = 1; j * j <= i; j++) { // 1 ~ i의 제곱근까지 반복
                if(j*j == i) { // j의 제곱이 i라면 해당 수의 최소값은 1
                    min = 1;
                    break;
                }
                // 1 ~ 제곱근 범위의 정수의 제곱수(즉, 1이 된다.)와,
                // i에서 해당 제곱수를 뺀 인덱스 값을 더한 값 중 최소값을 찾는다.
                min = Math.min(min, dp[i - j*j] + 1); 
            }
            dp[i] = min;
        }
        bw.write(String.valueOf(dp[n]));
        bw.close();
    }
}