import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int n, m;
    public static boolean[] visitedAry;
    public static int[] ary;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visitedAry = new boolean[n];
        ary = new int[n];

        int[] result = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ary[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(ary);

        dfs(0, result);
        bw.write(sb.toString());
        bw.close();
    }

    public static void dfs(int start, int[] result) {
        if(start == m) {
            for (int i = 0; i < m; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        int before = 0;
        for (int i = 0; i < n; i++) {
            int tmp = ary[i];
            // 이미 방문했던 '숫자'는 다시 방문하지 않는다.
            if(!visitedAry[i] && before != tmp) {
                result[start] = tmp;
                visitedAry[i] = true; // ary의 i번째 원소 방문했음을 기록
                dfs(start+1, result);
                visitedAry[i] = false;
                before = ary[i];
            }
        }
    }
}