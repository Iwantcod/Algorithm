import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static class Node {
        int y, x, r;
        Node(int y, int x, int r) {
            this.y = y;
            this.x = x;
            this.r = r;
        }
    }
    static int n, m, d, cnt = 0;
    static int[][] map;
    static int[] status = new int[3]; // 각 궁수의 위치 열 번호
    static boolean[] visited; // 궁수 위치 경우의 수 계산을 위한 방문 여부 표시 배열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] sp1 = br.readLine().split(" ");
        n = Integer.parseInt(sp1[0]);
        m = Integer.parseInt(sp1[1]);
        visited = new boolean[m];
        d = Integer.parseInt(sp1[2]);
        map = new int[n][m];
        for(int i = 0; i < n; i++) {
            String[] sp2 = br.readLine().split(" ");
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(sp2[j]);
            }
        }
        dfs(0, 0);
        bw.write(String.valueOf(cnt));
        bw.close();
    }
    public static void dfs(int depth, int start) {
        if(depth == 3) {
            int tmp = bfs();
            cnt = Math.max(tmp, cnt);
            return;
        }

        for(int i = start; i < m; i++) {
            if(!visited[i]) {
                status[depth] = i;
                visited[i] = true;
                dfs(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }
    public static int bfs() {
        int line = n;
        int result = 0;
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};
        boolean[][] dead = new boolean[n][m];
        while(line >= 1) {
            Queue<Node> q = new LinkedList<>();
            Set<String> set = new HashSet<>();
            for(int i = 0; i < status.length; i++) {
                Node min = new Node(100, 100, 100);
                boolean[][] visitArea = new boolean[n][m];
                if(map[line-1][status[i]] == 1 && !dead[line-1][status[i]]) {
                    min = new Node(line-1, status[i], 1);
                    set.add(""+min.y+" "+min.x);
                    continue;
                }
                q.add(new Node(line-1, status[i], 1));
                visitArea[line-1][status[i]] = true;
                
                while(!q.isEmpty()){
                    Node cur = q.poll();
                    if(cur.r > d) {
                        continue;
                    }
                    if(map[cur.y][cur.x] == 1 && !dead[cur.y][cur.x]) {
                        if((min.r == cur.r && min.x > cur.x) || min.r > cur.r) {
                            min = cur;
                        }
                    }
                    for(int j = 0; j < 4; j++) {
                        int ny = cur.y + dy[j];
                        int nx = cur.x + dx[j];
                        if(ny >= 0 && nx >= 0 && ny < line && nx < m && !visitArea[ny][nx]) {
                            visitArea[ny][nx] = true;
                            Node next = new Node(ny, nx, cur.r + 1);
                            q.add(next);
                        }
                    }
                }
                if(min.x != 100 && !dead[min.y][min.x]) {
                    set.add(""+min.y+" "+min.x);
                }
            }
            for(String cur : set) {
                String[] attack = cur.split(" ");
                int y = Integer.parseInt(attack[0]);
                int x = Integer.parseInt(attack[1]);
                dead[y][x] = true;
                result++;
            }
            line--;
        }
        return result;
    }
}