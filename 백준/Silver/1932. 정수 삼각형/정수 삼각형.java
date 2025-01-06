import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] ary = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                ary[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 제일 윗층에서는 계산할 것이 없으므로, 그 아래층부터 계산을 시작한다.
        for (int i = 1; i < n; i++) {

            // 각 층의 첫번째와 마지막은 계산 불필요
            ary[i][0] += ary[i-1][0];
            ary[i][i] += ary[i-1][i-1];
            for (int j = 1; j < i; j++) {
                ary[i][j] += Math.max(ary[i-1][j-1], ary[i-1][j]);
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            if(ary[n-1][i] > result) {
                result = ary[n-1][i];
            }
        }
        bw.write(String.valueOf(result));
        bw.close();
    }
}