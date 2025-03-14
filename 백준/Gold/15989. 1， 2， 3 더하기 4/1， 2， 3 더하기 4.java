import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] ary = new int[10001][4];
        ary[1][1] = 1;
        ary[2][1] = 1; ary[2][2] = 1;
        ary[3][1] = 1; ary[3][2] = 1; ary[3][3] = 1;
        for (int i = 4; i < 10001; i++) {
            ary[i][1] = ary[i-1][1];
            ary[i][2] = ary[i-2][2] + ary[i-2][1];
            ary[i][3] = ary[i-3][3] + ary[i-3][2] + ary[i-3][1];
        }

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int result = ary[n][1] + ary[n][2] + ary[n][3];
            bw.write(String.valueOf(result)+"\n");
        }
        bw.close();
    }
}