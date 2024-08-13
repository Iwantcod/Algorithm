import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer strtk = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(strtk.nextToken());
        int k = Integer.parseInt(strtk.nextToken());
        int[] ary = new int[N];
        int[] result = new int[N];
        int[] smallNum = {10001, 0};

        StringTokenizer strtk2 = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            ary[i] = Integer.parseInt(strtk2.nextToken());
        }

        // 배열 내 가장 작은 수와 그 인덱스 번호를 알아내고, 그 수를 결과 배열에 넣은 다음 그 수가 원래 있던 배열의 인덱스의 값을 10001로 바꾼다.(이후 검증때 제외시킨다.)
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(ary[j] < smallNum[0]) {
                    smallNum[0] = ary[j];
                    smallNum[1] = j;
                }
            }
            result[i] = smallNum[0];
            ary[smallNum[1]] = 10001;
            smallNum[0] = 10001;
        }

        bw.write(String.valueOf(result[N-k]));
        bw.close();
    }
}