import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 집의 수
        int N = Integer.parseInt(br.readLine());
        int[][] ary = new int[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            ary[i][0] = Integer.parseInt(st.nextToken()); // R 칠하는 비용
            ary[i][1] = Integer.parseInt(st.nextToken()); // G 칠하는 비용
            ary[i][2] = Integer.parseInt(st.nextToken()); // B 칠하는 비용
        }

        int[][] result = new int[N][3];
        result[0][0] = ary[0][0];
        result[0][1] = ary[0][1];
        result[0][2] = ary[0][2];
        for (int i = 1; i < N; i++) {
            result[i][0] = ary[i][0] + Math.min(result[i-1][1], result[i-1][2]);
            result[i][1] = ary[i][1] + Math.min(result[i-1][0], result[i-1][2]);
            result[i][2] = ary[i][2] + Math.min(result[i-1][0], result[i-1][1]);
        }
        int minVal = Math.min(result[N-1][0], Math.min(result[N-1][1], result[N-1][2]));
        bw.write(String.valueOf(minVal));
        bw.close();
    }
}