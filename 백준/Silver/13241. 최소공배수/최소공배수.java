import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer strtk = new StringTokenizer(br.readLine(), " ");
        long A = Long.parseLong(strtk.nextToken());
        long B = Long.parseLong(strtk.nextToken());
        long result = 0L;
        br.close();

        if(A>B) {
            result = A*B/findGCD(A, B);
        } else if (B>A) {
            result = A*B/findGCD(B, A);
        } else {
            result = A;
        }

        bw.write(String.valueOf(result));
        bw.close();
    }

    // 최소공배수 구하는 공식: A*B/최대공약수
    // 아래 함수는 최대공약수를 구하는 함수
    static long findGCD(long A, long B) {
        while(B != 0) {
            long R = A%B;
            A = B;
            B = R;
        }
        return A;
    }
}
