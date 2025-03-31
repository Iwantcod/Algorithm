import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] ary = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        ary[0] = Integer.parseInt(st.nextToken());
        // 해당 수 까지의 누적합 결과를 배열에 메모해나간다(DP)
        for (int i = 1; i < n; i++) {
            ary[i] = ary[i-1] + Integer.parseInt(st.nextToken());
        }

        // 0 ~ k번째 온도의 총합이 계산의 첫번째 결과값이다.
        int max = ary[k-1];
        // k일 전 ~ 기준 일자 온도의 총합을 두 인덱스의 빼기 연산만으로 계산할 수 있다.
        // ex) c+d == (a+b+c+d) - (a+b)
        for (int i = k; i < n; i++) {
            int tmp = ary[i] - ary[i-k];
            if(tmp > max) {
                max = tmp;
            }
        }

        bw.write(String.valueOf(max));
        bw.close();
    }
}