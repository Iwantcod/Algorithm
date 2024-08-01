import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer strtk = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(strtk.nextToken());
        int M = Integer.parseInt(strtk.nextToken());

        int[] ary = new int[N];
        StringTokenizer strtk2 = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < N; i++) {
            ary[i] = Integer.parseInt(strtk2.nextToken());
        }
        Arrays.sort(ary);

        int a = 0;
        int result = M;
        for (int i = 0; i < N; i++) {

            for (int j = 0; j < N; j++) {
                if (i != j) {
                    for (int k = 0; k < N; k++) {
                        if(j != k && i != k) {
                            a = M - (ary[i] + ary[j] + ary[k]);
                            if(a < result && a >= 0) {
                                result = a;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(M-result);
    }
}