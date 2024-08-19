import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] B = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer strtk = new StringTokenizer(br.readLine(), " ");
            int tmp1 = Integer.parseInt(strtk.nextToken());
            int tmp2 = Integer.parseInt(strtk.nextToken());
            A[i] = Math.min(tmp1, tmp2);
            B[i] = Math.max(tmp1, tmp2);
        }

        for (int j = 0; j < N; j++) {
            int a = A[j];
            int b = B[j];
            if(A[j] == 1) {
                bw.write(String.valueOf(B[j])+"\n");
            } else {
                for (int k = 1; k <= B[j]; k++) {
                    if(a == b) {
                        bw.write(String.valueOf(a)+"\n");
                        break;
                    }

                    if(a >= b) {
                        b += B[j];
                    }
                    a += A[j];
                }
            }
        }
        bw.close();
    }
}