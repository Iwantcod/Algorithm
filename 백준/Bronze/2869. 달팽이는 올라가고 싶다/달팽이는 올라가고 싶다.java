import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int A = 0, B = 0, V = 0;
        do {
            StringTokenizer strtk = new StringTokenizer(br.readLine(), " ");
            A = Integer.parseInt(strtk.nextToken());
            B = Integer.parseInt(strtk.nextToken());
            V = Integer.parseInt(strtk.nextToken());
        } while (B < 1 || A < B || V > 1000000000);
        br.close();
        
        int dayUp = A - B;
        int length = V - A;
        int result = (int)Math.ceil((double)length / dayUp + 1);

        bw.write(String.valueOf(result));
        bw.close();
    }
}