import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] ary = new int[N+1];
        // dp배열: 특정 칸까지 가기 위한 최대 가중치값 정보
        int[] dp = new int[N+1];
        for (int i = 1; i <= N; i++) {
            ary[i] = Integer.parseInt(br.readLine());
        }
        dp[1] = ary[1];
        if(N >= 2) {
            dp[2] = ary[1] + ary[2];
        }

        for (int i = 3; i <= N; i++) {
            // 두칸 아래 계단을 밟고 목표 계단을 밟거나, 세칸 아래 계단과 한칸 아래 계단을 밟고 목표 계단을 밟을 수 있다.
            // 두칸 아래 계단까지 가는 최대 가중치 값(dp), 세칸 아래 계단까지 가는 최대 가중치값(dp) + 한칸 아래 계단의 가중치값(ary) 중 큰 값을 택하면 된다.
            dp[i] = Math.max(dp[i-2], dp[i-3] + ary[i-1]) + ary[i];
        }
        System.out.println(dp[N]);
    }
}