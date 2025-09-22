import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int n;
    static int[] w;
    static boolean[] visited;
    static boolean[][] map;
    static int total = 0;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        w = new int[n+1];
        visited = new boolean[n+1];
        map = new boolean[n+1][n+1];
        String[] wInput = br.readLine().split(" ");
        for(int i = 1; i <= n; i++) {
            w[i] = Integer.parseInt(wInput[i-1]);
            total += w[i];
        }
        
        for(int i = 1; i <= n; i++) {
            String[] dest = br.readLine().split(" ");
            int len = Integer.parseInt(dest[0]);
            for(int j = 1; j <= len; j++) {
                int target = Integer.parseInt(dest[j]);
                map[i][target] = true;
                map[target][i] = true;
            }
        }
        dfs(1, 0);
        if(min == Integer.MAX_VALUE) min = -1;
        bw.write(String.valueOf(min));
        bw.close();
    }
    public static void dfs(int start, int sum) {
        if(start > n) {
            if(sum == 0 || sum == total) {
                return;
            }
            if(!isConnect()) {
                return;
            }
            min = Math.min(min, (int)Math.abs(sum - (total - sum)));
            return;
        }

        visited[start] = true;
        dfs(start + 1, sum + w[start]);
        
        visited[start] = false;
        dfs(start + 1, sum);
    }
    public static boolean isConnect() {
        boolean[] check = new boolean[n+1];
        int redStart = 0;
        int blueStart = 0;
        for(int i = 1; i <= n; i++) {
            if(visited[i]) {
                redStart = i;
            } else {
                blueStart = i;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(redStart);
        check[redStart] = true;
        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int i = 1; i <= n; i++) {
                if(map[cur][i] == true && visited[i] == true && check[i] == false) {
                    check[i] = true;
                    q.add(i);
                }
            }
        }

        q.add(blueStart);
        check[blueStart] = true;
        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int i = 1; i <= n; i++) {
                if(map[cur][i] == true && visited[i] == false && check[i] == false) {
                    check[i] = true;
                    q.add(i);
                }
            }
        }

        for(int i = 1; i <= n; i++) {
            if(check[i] == false)
                return false;
        }
        return true;
    }
}