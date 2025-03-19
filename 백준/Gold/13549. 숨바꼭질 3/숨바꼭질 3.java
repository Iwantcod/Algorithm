import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());


        if(k < n) {
            bw.write(String.valueOf(n-k));
        } else {
            int[] ary = new int[k+1];
            // k가 n보다 작은 경우, 한칸씩 이동하며 접근하는 방법 뿐이다.
            for (int i = 0; i <= n; i++) {
                ary[i] = n - i;
            }

            for (int i = n+1; i <= k; i++) {
                // 짝수의 경우, '한칸 앞 인덱스의 값 + 1'과 'i/2 인덱스의 값' 중 더 작은 값을 선택한다.
                if(i % 2 == 0) {
                    ary[i] = Math.min(ary[i/2], ary[i-1] + 1);
                } else {
                    // 홀수의 경우, '한칸 앞 인덱스의 값 + 1'과 'i/2 + 1 인덱스의 값 + 1' 중 더 작은 값을 선택한다.
                    // 'i/2 인덱스의 값'을 조회하지 않는 이유는, 이 값이 '한칸 앞 인덱스의 값'과 동일하기 때문이다.
                    ary[i] = Math.min(ary[i-1], ary[i/2 + 1]) + 1;
                }
            }
            bw.write(String.valueOf(ary[k]));
        }
        bw.close();
    }
}