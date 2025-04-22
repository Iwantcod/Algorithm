import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static boolean[] visited;
    public static int[] result;
    public static int n, m;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        visited = new boolean[n+1];
        m = Integer.parseInt(st.nextToken());
        result = new int[m];
        dfs(0);
        bw.write(sb.toString());
        bw.close();

    }
    public static void dfs(int depth) {
        if(depth == m) {
            for(int i = 0; i < m; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= n; i++) {
            if(!visited[i]) {
                result[depth] = i;
                visited[i] = true;
                dfs(depth+1);
                
                visited[i] = false;
            }
        }
    }
}