import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] dp = new int[c+100]; // 최대 목표치 + 100의 값이 정답의 총 고객 수가 될 수 있다.
        // dp[i] == i명을 홍보하기 위한 최소 비용
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int cost = Integer.parseInt(st.nextToken());
            int customer = Integer.parseInt(st.nextToken());
            for(int j = customer; j < dp.length; j++) {
                if(dp[j - customer] != Integer.MAX_VALUE) {
                    // j명을 홍보하기 위해 기존에 계산된 비용, 자신의 홍보 효과 인원만큼 되돌아간 후(j-customer) 자신의 비용을 더한 값 중 더 작은 값을 반영
                    dp[j] = Math.min(dp[j], cost + dp[j - customer]);
                }
            }
        }

        int result = Integer.MAX_VALUE;
        // 최소 c명 이상을 확보해야 하므로 c ~ c+100 까지의 인덱스를 순회하며 최소값을 찾아낸다.
        // 최소 비용일 때의 홍보한 고객의 수는 최대 c+100이 될 수 있기 때문이다.
        for(int i = c; i < dp.length; i++) {
            if(dp[i] < result) {
                result = dp[i];
            }
        }
        bw.write(String.valueOf(result));
        bw.close();
    }
}