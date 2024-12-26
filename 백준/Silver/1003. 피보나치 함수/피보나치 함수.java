import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 0~40번째 피보나치 수가 0번째, 1번째 피보나치 수를 호출한 횟수를 저장하기 위한 2차원 배열
        int[][] ary = new int[41][2];

        ary[0][0] = 1;
        ary[0][1] = 0;
        ary[1][0] = 0;
        ary[1][1] = 1;

        for (int i = 2; i < ary.length; i++) {
            ary[i][0] = ary[i-2][0] + ary[i-1][0];
            ary[i][1] = ary[i-2][1] + ary[i-1][1];
        }

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            bw.write(String.valueOf(ary[N][0])+" "+String.valueOf(ary[N][1])+"\n");
        }
        bw.close();
    }
}