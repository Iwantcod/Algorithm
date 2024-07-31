import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // f(n) = a1*n0 + a0, g(n) = n
        // 모든 n >= n0 에서  f(n) <= c * g(n) 이 성립하는가?
        StringTokenizer strtk = new StringTokenizer(br.readLine()," ");
        int a1 = Integer.valueOf(strtk.nextToken());
        int a0 = Integer.valueOf(strtk.nextToken());
        int c = Integer.parseInt(br.readLine());
        int n0 = Integer.valueOf(br.readLine());

        // n0일때 식이 성립할때 c가 a1보다 크다면 n이 커져도 f(n)이 더 커질 수가 없다.
        if(a1*n0 + a0 <= c * n0 && c >= a1) {
            bw.write("1");
        } else {
            bw.write("0");
        }
        bw.close();
    }
}