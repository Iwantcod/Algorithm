import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = -1, b = -1;

        do {
            StringTokenizer strtk = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(strtk.nextToken());
            b = Integer.parseInt(strtk.nextToken());
            if(a != b) {
                if(a % b != 0 && b % a == 0) {
                    bw.write("factor");
                    bw.flush();
                } else if (a % b == 0 && b % a != 0) {
                    bw.write("multiple");
                    bw.flush();
                } else {
                    bw.write("neither");
                    bw.flush();
                }
                bw.write("\n");
                bw.flush();
            }
        } while (a != b);
        bw.close();
    }
}