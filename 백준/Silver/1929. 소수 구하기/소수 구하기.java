import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer strtk = new StringTokenizer(br.readLine(), " ");
        int M = Integer.parseInt(strtk.nextToken());
        int N = Integer.parseInt(strtk.nextToken());

        boolean[] ary = new boolean[N+1];
        ary[1] = true; // 숫자 1은 소수가 아니므로 예외처리

        for (int i = 2; i*i <= N; i++) {
            for (int j = i*2; j <= N; j += i) { // i*2부터 시작해서 걸러내는 이유는, i부터 걸러내면 소수까지 걸러버릴 수 있기 때문
                ary[j] = true;
            }
        }

        for (int i = M; i <= N; i++) {
            if(!ary[i]) {
                bw.write(String.valueOf(i)+"\n");
            }
        }
        bw.close();
    }
}