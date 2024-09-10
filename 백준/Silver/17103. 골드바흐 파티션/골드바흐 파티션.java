import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2 ~ 1,000,000 사이의 소수를 알아내기 위한 배열
        boolean[] ary = new boolean[1000001];
        // 1은 소수가 아니므로 예외처리(인덱스 번호를 숫자로 취급. 소수가 아니면 true)
        ary[0] = ary[1] = true;
        for (int i = 2; i*i <= 1000000; i++) {
            for (int j = i * 2; j <= 1000000; j += i) {
                ary[j] = true;

            }
        }

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int cnt = 0;
            for (int j = 2; j <= N / 2; j++) {
                if(!ary[j] && !ary[N-j]) {
                    cnt++;
                }
            }
            bw.write(String.valueOf(cnt)+"\n");
        }
        bw.close();
    }
}