import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int n, m;
    public static int[] result;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        result = new int[m];

        dfs(1, 0);
        bw.write(sb.toString());
        bw.close();
    }

    public static void dfs(int start, int index) {
        if(index == m) {
            for (int i = 0; i < m; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        // 반복문의 i는 1씩 증가
        for (int i = start; i <= n; i++) {
            result[index] = i;
            dfs(i,index + 1); // 다음 순서로 올 숫자는 i보다 같거나 큰 숫자만 취급한다.
        }
    }
}