import java.io.*;
import java.util.function.IntToDoubleFunction;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int total, n, k, a, b, sum = 0;
        String x;

        do {
            total = Integer.parseInt(br.readLine());
        } while (total < 1 || total > 1000000000);
        do {
            n = Integer.parseInt(br.readLine());
        } while (n < 1 || n > 100);

        for (int i = 0; i<n; i++) {
            do {
                x = br.readLine();
                a = Integer.parseInt(x.split(" ")[0]);
                b = Integer.parseInt(x.split(" ")[1]);
            } while (a < 1 || a > 1000000 || b < 1 || b > 10);
            sum += a * b;       // a, b를 올바르게 입력했다면 이 둘을 곱한값을 sum에 계속 더한다.
        }
        br.close();

        if(sum == total) {
            bw.write("Yes");
        } else {
            bw.write("No");
        }
        bw.close();
    }
}