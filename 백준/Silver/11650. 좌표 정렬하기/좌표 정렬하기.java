import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] ary = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer strtk = new StringTokenizer(br.readLine(), " ");
            ary[i][0] = Integer.parseInt(strtk.nextToken());
            ary[i][1] = Integer.parseInt(strtk.nextToken());
        }


        // JAVA 2차원 배열 LAMBDA식 이용 오름차순 정렬
        Arrays.sort(ary, (o1, o2) -> {
            if(o1[0] == o2[0]) {    // 0번째 숫자가 같은 경우, 1번째 숫자를 비교하여 오름차순 정렬
                return o1[1]-o2[1];
            } else {
                return o1[0]-o2[0];
            }
        });

        for (int i = 0; i < N; i++) {
            bw.write(String.valueOf(ary[i][0])+" "+String.valueOf(ary[i][1])+"\n");
        }
        bw.close();
    }
}