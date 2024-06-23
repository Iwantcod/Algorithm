import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] ary = new int[9][9];
        int big = 0;        // 가장 큰 수 탐색을 위해 필요한 변수
        int[] index = {1, 1};   // 가장 큰 수의 인덱스 번호 저장을 위한 변수

        for (int i = 0; i < 9; i++) {
            StringTokenizer strtk = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 9; j++) {
                ary[i][j] = Integer.parseInt(strtk.nextToken());
                if(ary[i][j] > big) {       // 큰수 찾으면 그 수를 저장하고 해당 인덱스 번호까지 저장
                    big = ary[i][j];
                    index[0] = i+1;
                    index[1] = j+1;
                }
            }
        }
        System.out.println(big);
        System.out.print(index[0]+" "+index[1]);
    }
}