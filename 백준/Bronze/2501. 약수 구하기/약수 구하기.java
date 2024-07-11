import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int result = 0;
        StringTokenizer strtk = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(strtk.nextToken());
        int K = Integer.parseInt(strtk.nextToken());

//        for (int i = 1; i <= N; i++) {
//            if(N % i == 0 && K == 0) {
//                result = i;
//            } else if (N % i == 0) {
//                K--;
//            }
//        }

        boolean isContinue = true;
        int i = 1;
        while (isContinue) {
            if(N % i == 0) {
                K--;
            } else if (i > N) {
                isContinue = false;
            }
            if(K == 0) {
                result = i;
                isContinue = false;
            }
            i++;
        }

        bw.write(String.valueOf(result));
        bw.close();
    }
}