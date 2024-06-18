import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = 0, M = 0;
        do {
            StringTokenizer strtk = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(strtk.nextToken());
            M = Integer.parseInt(strtk.nextToken());
        } while (N < 1 || M < 1 || N > 100 || M > 100);

        int[][] ary = new int[N][M];

        int newI = 0;

        for (int i = 0; i < N*2; i++) {     // 입력받는 횟수는 (N*2)*M개 이다.
            newI = i%N;     // 입력값 저장할 행번호 지정을 위한 값 계산
            StringTokenizer strtk = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                ary[newI][j] += Integer.parseInt(strtk.nextToken());        // 두 배열을 선언할 필요없이, 처음부터 각 인덱스에 입력되는 모든 값을 더한다.
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(ary[i][j]+" ");
            }
            System.out.println();
        }
    }
}