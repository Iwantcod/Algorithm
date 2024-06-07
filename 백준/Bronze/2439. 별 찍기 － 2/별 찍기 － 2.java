import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n;
        do {
            n = Integer.parseInt(br.readLine());
        } while (n < 1 || n > 100);
        br.close();

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < n - i; j++) {
                bw.write(' ');
            }
            for (int k = 0; k < i; k++) {
                bw.write('*');
            }
            bw.write('\n');
        }
        bw.close();
    }
}