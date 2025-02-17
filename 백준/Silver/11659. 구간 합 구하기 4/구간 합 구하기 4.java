import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] ary = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            // 해당 자리까지의 누적합 값을 기록
            ary[i] = Integer.parseInt(st.nextToken()) + ary[i-1];
        }

//        System.out.println();
//        for (int i = 1; i <= n; i++) {
//            System.out.print(ary[i]+" ");
//        }

        // ex) 3 ~ 5번째 수의 합: (1번째 ~ 5번째 총합) - (1번째 ~ 2번째 총합)
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int result = ary[end] - ary[start - 1];
            bw.write(String.valueOf(result) + "\n");
        }
        bw.close();
    }
}