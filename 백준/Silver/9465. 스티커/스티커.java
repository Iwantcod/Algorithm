import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] aryA = new int[N];
            int[] aryB = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < N; k++) {
                aryA[k] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < N; k++) {
                aryB[k] = Integer.parseInt(st.nextToken());
            }

            // DP 알고리즘은 N이 3 이상인 경우에 적용할 수 있으므로, N이 1이나 2인 경우를 예외처리
            if(N == 1) {
                bw.write(String.valueOf(Math.max(aryA[0], aryB[0]))+"\n");
            } else if(N == 2) {
                bw.write(String.valueOf(Math.max(aryA[0] + aryB[1], aryB[0] + aryA[1]))+"\n");
            } else {
                aryA[1] += aryB[0];
                aryB[1] += aryA[0];

                for (int j = 2; j < N; j++) {
                    aryA[j] += Math.max(aryB[j-1], aryB[j-2]);
                    aryB[j] += Math.max(aryA[j-1], aryA[j-2]);
                }
                bw.write(String.valueOf(Math.max(aryA[N-1], aryB[N-1]))+"\n");
            }
        }
        bw.close();
    }
}