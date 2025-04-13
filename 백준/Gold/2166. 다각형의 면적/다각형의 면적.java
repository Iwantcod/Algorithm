import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[][] ary = new long[n+1][2];
        StringTokenizer st;
        for(int i = 0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            ary[i][0] = Long.parseLong(st.nextToken());
            ary[i][1] = Long.parseLong(st.nextToken());
        }

        ary[n][0] = ary[0][0];
        ary[n][1] = ary[0][1];

        long result = 0L;
        for(int i = 0; i < n; i++) {
            result += ary[i][0] * ary[i+1][1];
            result -= ary[i][1] * ary[i+1][0];
        }

        String str = String.format("%.1f", (Math.abs(result)/2.0));
        bw.write(str);
        bw.close();
        
    }
}