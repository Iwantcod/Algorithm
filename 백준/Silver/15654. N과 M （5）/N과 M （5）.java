import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int n, m;
    public static int[] result;
    public static StringBuilder sb = new StringBuilder();
    public static boolean[] isEnter;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[] ary = new int[n];
        result = new int[m];
        isEnter = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ary[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(ary);
        dfs(0, ary);
        System.out.print(sb.toString());
    }

    public static void dfs(int cnt, int[] ary) {
        if(cnt == m) {
            for (int i = 0; i < m; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if(!isEnter[i]) {
                isEnter[i] = true;
                result[cnt] = ary[i];
                dfs(cnt + 1, ary);

                isEnter[i] = false; // 방금 순회했던 수를 방문 기록에서 삭제 -> 다음 경우의 수 계산을 위함
            }
        }

    }
}