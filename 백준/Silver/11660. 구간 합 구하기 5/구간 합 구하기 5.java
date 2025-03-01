import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] ary = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int cur = Integer.parseInt(st.nextToken());
                if(i == 0 && j == 0) {
                    ary[i][j] = cur;
                } else if(j >= 1) {
                    ary[i][j] = ary[i][j - 1] + cur;
                } else if(j == 0) {
                    ary[i][j] = ary[i-1][n-1] + cur;
                }
            }
        }
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int result = 0;
            int[] start = {Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1};
            int[] end = {Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1};

            for (int j = start[0]; j <= end[0]; j++) {
                if(j == 0 && start[1] == 0) {
                    result += ary[j][end[1]];
                } else if(start[1] == 0) {
                    result += ary[j][end[1]] - ary[j-1][n-1];
                } else {
                    result += ary[j][end[1]] - ary[j][start[1]-1];
                }
            }
            bw.write(String.valueOf(result)+"\n");
        }

        bw.close();
    }
}