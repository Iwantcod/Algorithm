import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int M = 0, N = 0;
        do {
            M = Integer.parseInt(br.readLine());
        } while (M < 1 || M > 10000);
        do {
            N = Integer.parseInt(br.readLine());
        } while (N < M || N > 10000);
        br.close();

        boolean[] ary = new boolean[N+1];
        ary[1] = true;  // 1은 소수가 아니므로 미리 빼놓기.

        for (int i = 2; i < ary.length; i++) {      // 알고리즘: 에라토테네스의 체
            if(!ary[i]) {
                for (int j = i*2; j < ary.length; j += i) {
                    ary[j] = true;
                }
            }
        }

        boolean isFirst = true;
        int result = 0, firstNum = 0;
        for (int i = M; i < ary.length; i++) {
            if(!ary[i]) {
                if(isFirst) {
                    firstNum = i;
                    isFirst = false;
                }
                result += i;
            }
        }

        if (firstNum == 0) {
            bw.write("-1");
        } else {
            bw.write(String.valueOf(result)+"\n"+String.valueOf(firstNum));
        }
        bw.close();
    }
}