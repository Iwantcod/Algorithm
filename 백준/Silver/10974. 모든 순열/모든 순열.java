import java.util.*;
import java.io.*;

class Main {
    public static boolean[] visited;
    public static int[] result;
    public static int n;
    public static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n+1];
        result = new int[n+1];

        dfs(1);
        bw.write(sb.toString());
        bw.close();
    }
    public static void dfs(int depth) {
        if(depth > n) {
            for(int i = 1; i <= n; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= n; i++) {
            if(visited[i] == false) {
                visited[i] = true;
                result[depth] = i;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}