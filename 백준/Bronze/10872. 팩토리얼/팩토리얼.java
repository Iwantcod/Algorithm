import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String a = br.readLine();
        br.close();
        int n = Integer.parseInt(a);

        String x = String.valueOf(fac(n));
        bw.write(x);
        bw.close();

    }
    public static int fac(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * fac(n-1);
        }
    }
}