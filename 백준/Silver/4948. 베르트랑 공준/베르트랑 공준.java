import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = -1;
        boolean[] ary = new boolean[246913];        // 2 ~ 246,913번째 인덱스를 사용
        ary[1] = true;
        for (int i = 2; i*i <= 246913; i++) {       // 2 ~ 246,913 사이의 모든 소수가 아닌 수를 판별(에라토스테네스의 체)
            for (int j = i*2; j <= 246913; j += i) {
                ary[j] = true;
            }
        }

        while(n != 0) {
            n = Integer.parseInt(br.readLine());
            if(n != 0) {
                int cnt = 0;
                for (int i = n+1; i <= n * 2; i++) { // n보다 '크고' 2n보다 작거나 같은 소수의 개수를 계산
                    if(!ary[i]) {
                        cnt++;
                    }
                }
                bw.write(String.valueOf(cnt)+"\n");
            }
        }
        bw.close();
    }
}