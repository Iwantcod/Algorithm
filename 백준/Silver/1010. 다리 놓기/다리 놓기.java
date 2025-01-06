import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] ary = new int[31][31];
        // 1개의 다리가 n개의 다리와 연결되는 경우의 수: n가지
        for (int i = 1; i <= 30; i++) {
            ary[1][i] = i;
        }
        // x개의 다리와 y개의 다리가 연결되는 경우의 수: (x, y)로 표현
        // (x, y): (x, y-1) + (x-1, y-1)
        // (x, y): 가장 윗쪽에 생성한 다리를 한칸씩 내리면서 생성하며 그 상황에 맞는 경우의 수들을 모두 더한 값
        // 직전에 계산한 값과 차이점은, y가 1 증가하였다는 것 뿐이다 -> 그에 맞는 추가적인 경우의 수는 (x-1, y-1)이 가지고 있다.
        for (int i = 2; i <= 30; i++) {
            for (int j = i; j <= 30; j++) {
                ary[i][j] = ary[i][j-1] + ary[i-1][j-1];
            }
        }

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int indexA = Integer.parseInt(st.nextToken());
            int indexB = Integer.parseInt(st.nextToken());
            bw.write(ary[indexA][indexB] + "\n");
        }
        bw.close();
    }
}