import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = 0;
        double m = 0.0;
        do {
            n = Integer.parseInt(br.readLine());
        } while (n > 1000 || n < 1);

        double[] ary = new double[n];
        boolean isDone = false;
        do {
            StringTokenizer a = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < n; i++) {
                ary[i] = Integer.parseInt(a.nextToken());
                if(ary[i] < 0 || ary[i] > 100) {
                    isDone = true;
                } else {
                    isDone = false;
                }
                if(ary[i] > m) {        // 최대점수인 m을 찾기위함
                    m = ary[i];
                }
            }
        } while(isDone);
        br.close();

        double sum = 0;
        for(int j = 0; j < n; j++) {
            ary[j] = (ary[j]/m) * 100;
            sum += ary[j];
        }
        bw.write(String.valueOf(sum/n));
        bw.close();
    }
}