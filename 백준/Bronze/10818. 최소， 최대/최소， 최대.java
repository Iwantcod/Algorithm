import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer strtk = new StringTokenizer(br.readLine()," ");
        int[] x = new int[n];

        for(int i = 0; i<n; i++) {
            x[i] = Integer.parseInt(strtk.nextToken());
        }
        br.close();
        Arrays.sort(x);
        bw.write(String.valueOf(x[0])+" "+String.valueOf(x[n-1]));
        bw.close();
    }
}