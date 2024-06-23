import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] ary = new int[101][101]; // 도화지의 크기: (0, 0) ~ (100, 100) => 101 * 101

        int num = Integer.parseInt(br.readLine());
        int x = 0, y = 0;
        int cnt = 0;

        for (int i = 0; i < num; i++) {
            StringTokenizer strtk = new StringTokenizer(br.readLine(), " ");
            x = Integer.parseInt(strtk.nextToken());
            y = Integer.parseInt(strtk.nextToken());
            for (int j = x; j < x+10; j++) {
                for (int k = y; k < y+10; k++) {
                    if(ary[j][k] == 0) {
                        ary[j][k] = 1;
                        cnt++;
                    }
                }
            }
        }
        System.out.print(cnt);
    }
}