import java.util.*;
import java.io.*;

class Main {
    public static boolean[] visited;
    public static int[] result;
    public static int n, m;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] sp = br.readLine().split(" ");
        n = Integer.parseInt(sp[0]);
        m = Integer.parseInt(sp[1]);
        visited = new boolean[n+1];
        result = new int[m];

        dfs(0);
        bw.write(sb.toString());
        bw.close();
    }
    public static void dfs(int depth) {
        if (depth == m) {
            for(int cur : result) {
                sb.append(cur).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= n; i++) {
            if(visited[i] == false) {
                visited[i] = true;
                result[depth] = i;
                dfs(depth+1);
                visited[i] = false;
            }
        }
    }
}